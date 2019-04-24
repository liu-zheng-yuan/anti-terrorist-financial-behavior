package edu.nju.antiTerroristFinancialBehavior.mapper;

import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
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

    /**
     * 根据id查对应二级指标
     *
     * @param id
     * @return
     */
    SecondIndex selectByPrimaryKey(Integer id);
    /**
     * 查所属一级指标的Id
     *
     * @param secondIndexId
     * @return
     */
    int getSecondIndexParentId(Integer secondIndexId);
    /**
     * 增加二级指标
     *
     * @param secondIndex
     * @return
     */
    void addSecondIndex(SecondIndex secondIndex);
}
