package edu.nju.antiTerroristFinancialBehavior.mapper;

import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author fanleehao on 2019/4/19
 */

public interface FirstIndexMapper {

    FirstIndex findFirstIndexById(Integer id);

    List<FirstIndex> findAllFirstIndex();

    List<SecondIndex> findSecondIndices(Integer id);
}
