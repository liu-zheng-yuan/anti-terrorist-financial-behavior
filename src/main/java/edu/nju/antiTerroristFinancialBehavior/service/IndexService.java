package edu.nju.antiTerroristFinancialBehavior.service;

import edu.nju.antiTerroristFinancialBehavior.mapper.FirstIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.MenuItem;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
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
            MenuItem firstMenuItem = new MenuItem("", false, 0, 0, "", "", 2, firstIndex.getMenuID(), firstIndex.getIndex_name(), 0,"");
            menuItemList.add(firstMenuItem);
        }
        //添加二级指标
        for (FirstIndex firstIndex : firstIndices) {
            List<SecondIndex> secondIndices = firstIndexMapper.findSecondIndices(firstIndex.getId());
            for (SecondIndex secondIndex: secondIndices) {
                secondIndex.setMenuID(menuID++);
                MenuItem secondMenuItem = new MenuItem("/weightList/" + secondIndex.getId(), false, 0, firstIndex.getMenuID(), "", "", 3, secondIndex.getMenuID(), secondIndex.getIndex_name(), 0,"");
                menuItemList.add(secondMenuItem);
            }
        }

        return menuItemList;
    }
}
