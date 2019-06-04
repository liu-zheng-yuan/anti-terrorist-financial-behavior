package edu.nju.antiTerroristFinancialBehavior.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import edu.nju.antiTerroristFinancialBehavior.mapper.*;
import edu.nju.antiTerroristFinancialBehavior.mapper.weight.FirstIndexWeightMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.weight.FourthIndexWeightMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.weight.SecondIndexWeightMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.weight.ThirdIndexWeightMapper;
import edu.nju.antiTerroristFinancialBehavior.model.*;
import edu.nju.antiTerroristFinancialBehavior.model.matrix.ZeroIndexMatrix;
import edu.nju.antiTerroristFinancialBehavior.model.weight.FirstIndexWeight;
import edu.nju.antiTerroristFinancialBehavior.model.weight.FourthIndexWeight;
import edu.nju.antiTerroristFinancialBehavior.model.weight.SecondIndexWeight;
import edu.nju.antiTerroristFinancialBehavior.model.weight.ThirdIndexWeight;
import edu.nju.antiTerroristFinancialBehavior.utils.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author fanleehao on 2019/4/19
 * 数据初始化service
 */

@Service
public class CommonIndexService {

    @Autowired
    private FirstIndexMapper firstIndexMapper;

    @Autowired
    private SecondIndexMapper secondIndexMapper;

    @Autowired
    private ThirdIndexMapper thirdIndexMapper;

    @Autowired
    private FourthIndexMapper fourthIndexMapper;

    @Autowired
    private FirstIndexWeightMapper firstIndexWeightMapper;

    @Autowired
    private SecondIndexWeightMapper secondIndexWeightMapper;

    @Autowired
    private ThirdIndexWeightMapper thirdIndexWeightMapper;

    @Autowired
    private FourthIndexWeightMapper fourthIndexWeightMapper;

    @Autowired
    private ProfessorMapper professorMapper;

    /**
     * 查找非最细粒度级指标，封装成json串；
     * 菜单列中只含一二三级指标，四级指标将根据三级指标的超链接请求查找（需要另外拼接）
     * @param id
     * @return
     */
    public List<MenuItem> findMenusItemsByParentID(Integer id) {

        List<MenuItem> menuItemList = new ArrayList<>();
        int menuID = 1;
        List<FirstIndex> firstIndices = firstIndexMapper.findAllFirstIndex();

        if(id == 1){
            //添加一级指标
            for (FirstIndex firstIndex : firstIndices) {
                menuID += 1;
                firstIndex.setMenuID(menuID);
                MenuItem firstMenuItem = new MenuItem("", false, 0, 0, "",
                        "", 2, firstIndex.getMenuID(), firstIndex.getIndex_name(), 0,"");
                menuItemList.add(firstMenuItem);
            }
            //添加二级及三级指标
            for (FirstIndex firstIndex : firstIndices) {
                Integer firstIndexId = firstIndex.getId();
                List<SecondIndex> secondIndices = firstIndexMapper.findSecondIndices(firstIndexId);

                for (SecondIndex secondIndex: secondIndices) {
                    menuID = menuID + 1;
                    secondIndex.setMenuID(menuID);
                    MenuItem secondMenuItem = new MenuItem("" + secondIndex.getId(), false,
                            0, firstIndex.getMenuID(), "", "", 3,
                            secondIndex.getMenuID(), secondIndex.getIndex_name(), 0,"");
                    menuItemList.add(secondMenuItem);
                }
                menuID += 1;
                menuItemList.add(new MenuItem("/weightAdd?parentIndexId=" + firstIndex.getId(), false,
                        0, firstIndex.getMenuID(), "", "", 3,
                        menuID, "新建", 0,""));

                /**
                 * 再依次查找所属三级指标
                 */
                for (SecondIndex secondIndex : secondIndices) {
                    Integer secondIndexId = secondIndex.getId();
                    List<ThirdIndex> thirdIndices = secondIndexMapper.findThirdIndicesBySecondIndexId(secondIndexId);
                    for (ThirdIndex thirdIndex : thirdIndices) {
                        menuID += 1;
                        thirdIndex.setMenuID(menuID);
                        MenuItem thirdMenuItem = new MenuItem("/index/list/" + thirdIndex.getId(), false,
                                0, secondIndex.getMenuID(), "", "", 4,
                                thirdIndex.getMenuID(), thirdIndex.getIndex_name(), 0,"");
                        menuItemList.add(thirdMenuItem);
                    }
                    menuID += 1;
                    menuItemList.add(new MenuItem("/weightAdd?parentIndexId=" + secondIndex.getId(), false,
                            0, secondIndex.getMenuID(), "", "", 4,
                            menuID, "新建", 0,""));

                }
            }
        }
        /**
         * 加载定权时的菜单
         */
        else if(id == 2){
            /**
             * 添加一个顶级（0）级指标，方便定权
             */
            MenuItem rootMenuItem = new MenuItem("/everyIndexMark?indexId=-1", false, 0, 0, "",
                    "", 2, menuID++, "初级指标", 0,"");
            menuItemList.add(rootMenuItem);

            //添加一级指标
            for (FirstIndex firstIndex : firstIndices) {
                menuID++;
                firstIndex.setMenuID(menuID);
                MenuItem firstMenuItem = new MenuItem("/everyIndexMark?indexId=" + firstIndex.getId(), false, 0, 0, "",
                        "", 2, firstIndex.getMenuID(), firstIndex.getIndex_name(), 0,"");
                menuItemList.add(firstMenuItem);
            }
            //添加二级及三级指标
            for (FirstIndex firstIndex : firstIndices) {

                List<SecondIndex> secondIndices = firstIndexMapper.findSecondIndices(firstIndex.getId());

                for (SecondIndex secondIndex: secondIndices) {
                    menuID++;
                    secondIndex.setMenuID(menuID);
                    MenuItem secondMenuItem = new MenuItem("/everyIndexMark?indexId=" + secondIndex.getId(), false,
                            0, firstIndex.getMenuID(), "", "", 3,
                            secondIndex.getMenuID(), secondIndex.getIndex_name(), 0,"");
                    menuItemList.add(secondMenuItem);
                }

                /**
                 * 再依次查找所属三级指标
                 */
                for (SecondIndex secondIndex : secondIndices) {
                    List<ThirdIndex> thirdIndices = secondIndexMapper.findThirdIndicesBySecondIndexId(secondIndex.getId());
                    for (ThirdIndex thirdIndex : thirdIndices) {
                        thirdIndex.setMenuID(++menuID);
                        MenuItem thirdMenuItem = new MenuItem("/everyIndexMark?indexId=" + thirdIndex.getId(), false,
                                0, secondIndex.getMenuID(), "", "", 4,
                                thirdIndex.getMenuID(), thirdIndex.getIndex_name(), 0,"");
                        menuItemList.add(thirdMenuItem);
                    }
                }
            }
        }

        /**
         * 加载权重展示的菜单
         */
        else if(id == 3){

            //添加一级指标
            for (FirstIndex firstIndex : firstIndices) {
                menuID++;
                firstIndex.setMenuID(menuID);
                MenuItem firstMenuItem = new MenuItem("/weightShow?indexId=" + firstIndex.getId(), false, 0, 0, "",
                        "", 2, firstIndex.getMenuID(), firstIndex.getIndex_name(), 0,"");
                menuItemList.add(firstMenuItem);
            }
            //添加二级及三级指标
            for (FirstIndex firstIndex : firstIndices) {

                List<SecondIndex> secondIndices = firstIndexMapper.findSecondIndices(firstIndex.getId());

                for (SecondIndex secondIndex: secondIndices) {
                    menuID++;
                    secondIndex.setMenuID(menuID);
                    MenuItem secondMenuItem = new MenuItem("/weightShow?indexId=" + secondIndex.getId(), false,
                            0, firstIndex.getMenuID(), "", "", 3,
                            secondIndex.getMenuID(), secondIndex.getIndex_name(), 0,"");
                    menuItemList.add(secondMenuItem);
                }

                /**
                 * 再依次查找所属三级指标
                 */
                for (SecondIndex secondIndex : secondIndices) {
                    List<ThirdIndex> thirdIndices = secondIndexMapper.findThirdIndicesBySecondIndexId(secondIndex.getId());
                    for (ThirdIndex thirdIndex : thirdIndices) {
                        thirdIndex.setMenuID(++menuID);
                        MenuItem thirdMenuItem = new MenuItem("/weightShow?indexId=" + thirdIndex.getId(), false,
                                0, secondIndex.getMenuID(), "", "", 4,
                                thirdIndex.getMenuID(), thirdIndex.getIndex_name(), 0,"");
                        menuItemList.add(thirdMenuItem);
                    }
                }
            }
        }


        return menuItemList;
    }

    /**
     * （“用户”权限时）查找一二级指标，封装成json串；
     * 菜单列中只含一二级指标，三级指标将根据二级指标的超链接请求查找（需要另外拼接）
     * @param id
     * @return
     */
    public List<MenuItem> findMenusItemsByParentIDUser(Integer id) {

        List<MenuItem> menuItemList = new ArrayList<>();
        int menuID = 1;

        List<FirstIndex> firstIndices = firstIndexMapper.findAllFirstIndex();
        //添加一级指标
        for (FirstIndex firstIndex : firstIndices) {
            firstIndex.setMenuID(menuID++);
            MenuItem firstMenuItem = new MenuItem("", false, 0, 0, "",
                    "", 2, firstIndex.getMenuID(), firstIndex.getIndex_name(), 0,"");
            menuItemList.add(firstMenuItem);
        }
        //添加二级及三级指标
        for (FirstIndex firstIndex : firstIndices) {

            List<SecondIndex> secondIndices = firstIndexMapper.findSecondIndices(firstIndex.getId());

            for (SecondIndex secondIndex: secondIndices) {
                secondIndex.setMenuID(menuID++);
                MenuItem secondMenuItem = new MenuItem("" + secondIndex.getId(), false,
                        0, firstIndex.getMenuID(), "", "", 3,
                        secondIndex.getMenuID(), secondIndex.getIndex_name(), 0,"");
                menuItemList.add(secondMenuItem);
            }
            menuID += 1;
            //用户权限无新建功能
//            menuItemList.add(new MenuItem("/weightAdd?parentIndexId=" + firstIndex.getId(), false,
//                    0, firstIndex.getMenuID(), "", "", 3,
//                    menuID, "新建", 0,""));

            /**
             * 再依次查找所属三级指标
             */
            for (SecondIndex secondIndex : secondIndices) {
                List<ThirdIndex> thirdIndices = secondIndexMapper.findThirdIndicesBySecondIndexId(secondIndex.getId());
                for (ThirdIndex thirdIndex : thirdIndices) {
                    thirdIndex.setMenuID(menuID++);
                    MenuItem thirdMenuItem = new MenuItem("/indexListUser/" + thirdIndex.getId(), false,
                            0, secondIndex.getMenuID(), "", "", 4,
                            thirdIndex.getMenuID(), thirdIndex.getIndex_name(), 0,"");
                    menuItemList.add(thirdMenuItem);
                }
                menuID += 1;
                //用户权限无新建功能
//                menuItemList.add(new MenuItem("/weightAdd?parentIndexId=" + secondIndex.getId(), false,
//                        0, secondIndex.getMenuID(), "", "", 4,
//                        menuID, "新建", 0,""));

            }
        }


        return menuItemList;
    }

    /**
     * 判断新增指标的父指标是第几级/判断一个指标是第几级的
     *
     * @param indexId
     * @return
     */
    public int getIndexLevel(String indexId) {
        FirstIndex firstIndex = firstIndexMapper.findFirstIndexById(Integer.valueOf(indexId));
        if (firstIndex!=null) {
            return 1;
        }
        SecondIndex secondIndex = secondIndexMapper.findSecondIndexById(Integer.valueOf(indexId));
        if (secondIndex != null) {
            return 2;
        }
        return 3;
    }


    /**
     * 找到一个三级指标所属二级指标的Id
     * 弃用：查询到的三级指标中，默认有所属一级指标和二级指标；查询所有指标类似
     * @param thirdIndexId
     * @return
     */
    @Deprecated
    public int getThirdIndexParentId(Integer thirdIndexId) {
        return thirdIndexMapper.getThirdIndexParentId(thirdIndexId);
    }


    /**
     * 找到一个二级指标所属一级指标的Id
     * 弃用
     * @param secondIndexId
     * @return
     */
    @Deprecated
    public int getSecondIndexParentId(Integer secondIndexId) {
        return secondIndexMapper.getSecondIndexParentId(secondIndexId);
    }

    /**
     * 把矩阵转化成的指标插入对应等级的表里（包括当前打分的专家编号）
     * @param weightResult,parentIndexId
     * @return
     */
    public void insertWeightMatrix(double[] weightResult, Integer parentIndexId) {
        Integer curProfessor = professorMapper.findMaxProfessorId();
        //一级指标权重的插入
        if (parentIndexId == -1) {
            List<FirstIndex> firstIndices = firstIndexMapper.findAllFirstIndex();
            if (weightResult.length != firstIndices.size()) {
                //指标的数量不能和权重的数量一一对应
                return;
            }

            for (int i = 0; i < weightResult.length; i++) {
                FirstIndexWeight newFirstWeight = new FirstIndexWeight();
                newFirstWeight.setFirst_index(firstIndices.get(i));
                newFirstWeight.setWeight(weightResult[i]);
                newFirstWeight.setProfessor(curProfessor);
                firstIndexWeightMapper.insertWeight(newFirstWeight);
            }
            return;
        }
        Integer level = getIndexLevel(String.valueOf(parentIndexId));
        if (level == 1) {
            //父指标是第一级，说明权重数组对应的指标是第二级
            List<SecondIndex> secondIndices = secondIndexMapper.findSecondIndicesByFirstIndexId(parentIndexId);
            if (weightResult.length != secondIndices.size()) {
                //指标的数量不能和权重的数量一一对应
                return;
            }
            for (int i = 0; i < weightResult.length; i++) {
                SecondIndexWeight newSecondWeight = new SecondIndexWeight();
                newSecondWeight.setSecond_index(secondIndices.get(i));
                newSecondWeight.setWeight(weightResult[i]);
                newSecondWeight.setProfessor(curProfessor);
                secondIndexWeightMapper.insertWeight(newSecondWeight);
            }
        } else if (level == 2) {
            //父指标是第二级，说明权重数组对应的指标是第三级
            List<ThirdIndex> thirdIndices = thirdIndexMapper.findThirdIndicesBySecondIndexId(parentIndexId);
            if (weightResult.length != thirdIndices.size()) {
                //指标的数量不能和权重的数量一一对应
                return;
            }
            for (int i = 0; i < weightResult.length; i++) {
                ThirdIndexWeight newThirdWeight = new ThirdIndexWeight();
                newThirdWeight.setThird_index(thirdIndices.get(i));
                newThirdWeight.setWeight(weightResult[i]);
                newThirdWeight.setProfessor(curProfessor);
                thirdIndexWeightMapper.insertWeight(newThirdWeight);
            }
        } else if (level == 3) {
            //父指标是第三级，说明权重数组对应的指标是第四级
            List<FourthIndex> fourthIndices = fourthIndexMapper.findFourthIndicesByThirdIndexId(parentIndexId);
            if (weightResult.length != fourthIndices.size()) {
                //指标的数量不能和权重的数量一一对应
                return;
            }
            for (int i = 0; i < weightResult.length; i++) {
                FourthIndexWeight newFourthWeight = new FourthIndexWeight();
                newFourthWeight.setFourth_index(fourthIndices.get(i));
                newFourthWeight.setWeight(weightResult[i]);
                newFourthWeight.setProfessor(curProfessor);
                fourthIndexWeightMapper.insertWeight(newFourthWeight);
            }
        }
        return;
    }


    //专家人数加一
    public void addProfessorNum() {
        professorMapper.addProfessorNum();
    }


    /**
     * 找出ID对应的最终权重
     */
    public ArrayList<Double> findResultWeights(ArrayList<Integer> idList){
        ArrayList<Double> ret = new ArrayList<>();

        for (Integer id : idList) {
            FourthIndexWeight finalWeight = fourthIndexWeightMapper.findFinalWeight(fourthIndexMapper.findFourthIndexById(id));
            ret.add(finalWeight.getWeight());
        }
        return ret;

    }

    /**
     * ID映射到name,四级指标
     */
    public ArrayList<String> findFouthIndecesNamesById(ArrayList<Integer> idList){
        ArrayList<String> ret = new ArrayList<>();
        for (Integer id: idList){
            FourthIndex fourthIndex = fourthIndexMapper.findFourthIndexById(id);
            ret.add(fourthIndex.getIndex_name());
        }
        return ret;
    }

}
