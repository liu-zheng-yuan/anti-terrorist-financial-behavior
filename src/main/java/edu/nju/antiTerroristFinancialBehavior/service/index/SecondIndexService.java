package edu.nju.antiTerroristFinancialBehavior.service.index;

import edu.nju.antiTerroristFinancialBehavior.mapper.SecondIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 二级指标业务逻辑
 *
 * @author fanleehao on 2019/4/25
 */


@Service
public class SecondIndexService {

    @Autowired
    private SecondIndexMapper secondIndexMapper;

    /**
     * 查询二级指标
     * @param secondIndexId
     * @return
     */
    public SecondIndex findSecondIndexById(Integer secondIndexId) {
        return secondIndexMapper.findSecondIndexById(secondIndexId);
    }

    /**
     * 更新二级指标
     * @param secondIndex
     */
    public void updateSecondIndex(SecondIndex secondIndex) {
        secondIndexMapper.updateSecondIndex(secondIndex);
    }

    /**
     * 删除，级联
     * @param id
     */
    public void deleteSecondIndex(Integer id) {
        secondIndexMapper.deleteSecondIndex(id);
        return;
    }

    /**
     * 新增
     * @param secondIndex
     */
    public void addSecondIndex(SecondIndex secondIndex) {
        secondIndexMapper.addSecondIndex(secondIndex);
        return;
    }
}
