package edu.nju.antiTerroristFinancialBehavior.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProfessorMapper {
    @Select("select max(id) from professor")
    Integer findMaxProfessorId();

    @Insert("INSERT INTO professor SELECT (SELECT MAX(id) FROM professor)+1")
    void addProfessorNum();
}
