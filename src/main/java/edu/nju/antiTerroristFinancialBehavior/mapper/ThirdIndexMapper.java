package edu.nju.antiTerroristFinancialBehavior.mapper;

import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;

import java.util.List;

/**
 * @author fanleehao on 2019/4/20
 */

public interface ThirdIndexMapper {

    List<FourthIndex> findFourthIndicesByThirdIndexId(Integer id);

    int getThirdIndexParentId(Integer thirdIndexId);

    void addThirdIndex(ThirdIndex thirdIndex);

    ThirdIndex findThirdIndexById(Integer thirdIndexId);
}
