package edu.nju.antiTerroristFinancialBehavior.mapper;

import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;

import java.util.List;

/**
 * 二级指标mapper
 *
 * @author fanleehao on 2019/4/20
 */

public interface SecondIndexMapper {

    /**
     * 根据二级指标查询所属三级指标
     * @param id
     * @return
     */
    List<ThirdIndex> findThirdIndicesBySecondIndexId(Integer id);

}
