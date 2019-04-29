package edu.nju.antiTerroristFinancialBehavior.mapper;

import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;

import java.util.List;

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

    /**
     * 查询所有某一类的四级指标
     * @param thirdIndexId
     * @return
     */
    List<FourthIndex> findFourthIndicesByThirdIndexId(Integer thirdIndexId);

    /**
     * 更新四级指标
     * @param fourthIndex
     */
    void updateFourthIndex(FourthIndex fourthIndex);

    /**
     * 删除四级指标
     * @param id
     */
    void deleteFourthIndexById(Integer id);

    /**
     * 增加四级指标
     * @param fourthIndex
     */
    void addFourthIndex(FourthIndex fourthIndex);

}
