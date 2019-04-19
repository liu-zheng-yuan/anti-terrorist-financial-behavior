package edu.nju.antiTerroristFinancialBehavior.service;

import edu.nju.antiTerroristFinancialBehavior.mapper.FirstIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fanleehao on 2019/4/19
 * 数据初始化service
 */

@Service
public class IndexService {

    @Autowired
    private FirstIndexMapper firstIndexMapper;

    public List<MenuItem> findMenusItemsByParentID(Integer id) {
        List<>
    }
}
