package edu.nju.antiTerroristFinancialBehavior.service;

import edu.nju.antiTerroristFinancialBehavior.mapper.FirstIndexMapper;
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
public class CommonIndexService {

    @Autowired
    private FirstIndexMapper firstIndexMapper;

    @Autowired
    private SecondIndexMapper secondIndexMapper;

    @Autowired
    private ThirdIndexMapper thirdIndexMapper;



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

}
