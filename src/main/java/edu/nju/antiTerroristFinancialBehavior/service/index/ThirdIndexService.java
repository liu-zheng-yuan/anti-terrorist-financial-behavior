package edu.nju.antiTerroristFinancialBehavior.service.index;

import edu.nju.antiTerroristFinancialBehavior.mapper.ThirdIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 三级指标业务逻辑处理
 *
 * @author fanleehao on 2019/4/25
 */

@Service
public class ThirdIndexService {

    @Autowired
    private ThirdIndexMapper thirdIndexMapper;

    /**
     * 查询三级指标
     * @param thirdIndexId
     * @return
     */
    public ThirdIndex findThirdIndexById(Integer thirdIndexId) {
        return thirdIndexMapper.findThirdIndexById(thirdIndexId);
    }

    /**
     * 更新三级指标
     * @param thirdIndex
     */
    public void updateThirdIndex(ThirdIndex thirdIndex) {
        thirdIndexMapper.updateThirdIndex(thirdIndex);
        return;
    }

    /**
     * 删除三级指标, 同时所属四级指标级联删除
     * @param id
     */
    public void deleteThirdIndex(Integer id) {
        thirdIndexMapper.deleteThirdIndex(id);
    }

    /**
     * 新增
     * @param thirdIndex
     */
    public void addThirdIndex(ThirdIndex thirdIndex) {
        thirdIndexMapper.addThirdIndex(thirdIndex);
    }
}
