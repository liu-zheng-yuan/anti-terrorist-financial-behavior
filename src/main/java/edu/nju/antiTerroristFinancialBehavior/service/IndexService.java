package edu.nju.antiTerroristFinancialBehavior.service;

import edu.nju.antiTerroristFinancialBehavior.mapper.FirstIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.FourthIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.SecondIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.ThirdIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanleehao on 2019/4/19
 * 数据初始化service
 */

@Service
public class IndexService {

    @Autowired
    private FirstIndexMapper firstIndexMapper;

    @Autowired
    private SecondIndexMapper secondIndexMapper;

    @Autowired
    private ThirdIndexMapper thirdIndexMapper;

    @Autowired
    private FourthIndexMapper fourthIndexMapper;


    /**
     * 查找一二级指标，封装成json串；
     * 菜单列中只含一二级指标，三级指标将根据二级指标的超链接请求查找（需要另外拼接）
     * @param id
     * @return
     */
    public List<MenuItem> findMenusItemsByParentID(Integer id) {

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
            menuItemList.add(new MenuItem("/weightAdd?parentIndexId=" + firstIndex.getId(), false,
                    0, firstIndex.getMenuID(), "", "", 3,
                    menuID, "新建", 0,""));

            /**
             * 再依次查找所属三级指标
             */
            for (SecondIndex secondIndex : secondIndices) {
                List<ThirdIndex> thirdIndices = secondIndexMapper.findThirdIndicesBySecondIndexId(secondIndex.getId());
                for (ThirdIndex thirdIndex : thirdIndices) {
                    thirdIndex.setMenuID(menuID++);
                    MenuItem thirdMenuItem = new MenuItem("/weightList/" + thirdIndex.getId(), false,
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


        return menuItemList;
    }

    public List<ThirdIndex> findThirdIndicesBySecondIndexId(Integer id) {
        return secondIndexMapper.findThirdIndicesBySecondIndexId(id);
    }

    public List<FourthIndex> findFourthIndicesByThirdIndexId(Integer id){
        return thirdIndexMapper.findFourthIndicesByThirdIndexId(id);
    }

    public FourthIndex findFourthIndexById(Integer id) {
        return fourthIndexMapper.findFourthIndexById(id);
    }

    public FourthIndex updateFourthIndex(FourthIndex fourthIndex) {

        FourthIndex oldFourthIndex = fourthIndexMapper.findFourthIndexById(fourthIndex.getId());

        oldFourthIndex.setIndex_name(fourthIndex.getIndex_name());
        oldFourthIndex.setDesc(fourthIndex.getDesc());
        oldFourthIndex.setDimension(fourthIndex.getDimension());
        oldFourthIndex.setNormalize(fourthIndex.getNormalize());
        oldFourthIndex.setRange(fourthIndex.getRange());
        oldFourthIndex.setType(fourthIndex.getType());
        oldFourthIndex.setWeight_num(fourthIndex.getWeight_num());
        oldFourthIndex.setWeight_deno(fourthIndex.getWeight_deno());
//        System.out.println(oldFourthIndex);


//        System.out.println(oldFourthIndex.getFirstIndex());
        fourthIndexMapper.updateFourthIndex(oldFourthIndex);
        return oldFourthIndex;
    }

    public void deleteFourthIndexById(Integer id){
        if(id != null) {
            fourthIndexMapper.deleteFourthIndexById(id);
        }
        return;
    }

    public void addFourthIndex(FourthIndex fourthIndex) {
        fourthIndexMapper.addFourthIndex(fourthIndex);
    }

    /**
     * 判断新增指标的父指标是第几级
     *
     * @param parentIndexId
     * @return
     */
    public int getParentIndexIdLevel(String parentIndexId) {
        FirstIndex firstIndex = firstIndexMapper.selectByPrimaryKey(Integer.valueOf(parentIndexId));
        if (firstIndex!=null) {
            return 1;
        }
        SecondIndex secondIndex = secondIndexMapper.selectByPrimaryKey(Integer.valueOf(parentIndexId));
        if (secondIndex != null) {
            return 2;
        }
        return 3;
    }
    /**
     * 找到一个三级指标所属二级指标的Id
     *
     * @param thirdIndexId
     * @return
     */
    public int getThirdIndexParentId(Integer thirdIndexId) {
        return thirdIndexMapper.getThirdIndexParentId(thirdIndexId);
    }
    /**
     * 找到一个二级指标所属一级指标的Id
     *
     * @param secondIndexId
     * @return
     */
    public int getSecondIndexParentId(Integer secondIndexId) {
        return secondIndexMapper.getSecondIndexParentId(secondIndexId);
    }

    /**
     * 查询三级指标
     * @param thirdIndexId
     * @return
     */
    public ThirdIndex findThirdIndexById(Integer thirdIndexId) {
        return thirdIndexMapper.findThirdIndexById(thirdIndexId);
    }

    public void addSecondIndex(SecondIndex secondIndex) {
        secondIndexMapper.addSecondIndex(secondIndex);

    }

    public void addThirdIndex(ThirdIndex thirdIndex) {
        thirdIndexMapper.addThirdIndex(thirdIndex);
    }
}
