package edu.nju.antiTerroristFinancialBehavior.mapper;

import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;

/**
 * @author fanleehao on 2019/4/20
 */

public interface FourthIndexMapper {

    /**
     * 查询四级指标
     * @param id
     * @return
     */
    FourthIndex findFourthIndexById(Integer id);

}
