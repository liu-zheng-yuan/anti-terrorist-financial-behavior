package edu.nju.antiTerroristFinancialBehavior.mapper;

import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author fanleehao on 2019/4/19
 */

public interface FirstIndexMapper {

    FirstIndex selectByPrimaryKey(Integer id);

    @Select("select * from first_index")
    List<FirstIndex> findAllFirstIndex();
}
