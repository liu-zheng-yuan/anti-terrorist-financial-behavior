package edu.nju.antiTerroristFinancialBehavior.mapper;

import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;

import java.util.List;

/**
 * @author fanleehao on 2019/4/20
 */

public interface ThirdIndexMapper {

    List<FourthIndex> findFourthIndicesByThirdIndexId(Integer id);

    int getThirdIndexParentId(Integer thirdIndexId);
}
