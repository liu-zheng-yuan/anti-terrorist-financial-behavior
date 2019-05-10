package edu.nju.antiTerroristFinancialBehavior.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProfessorMapper {
    @Select("select max(id) from professor")
    Integer findMaxProfessorId();
}
