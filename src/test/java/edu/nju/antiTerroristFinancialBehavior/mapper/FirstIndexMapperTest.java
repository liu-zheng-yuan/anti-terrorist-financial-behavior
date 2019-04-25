package edu.nju.antiTerroristFinancialBehavior.mapper;

import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@MapperScan("edu.nju.antiTerroristFinancialBehavior.mapper")
public class FirstIndexMapperTest {

    @Autowired
    private FirstIndexMapper firstIndexMapper ;

    @Test
    public void testSelectByPrimaryKey(){
        System.out.println(firstIndexMapper);
        //FirstIndex firstIndex = firstIndexMapper.findSecondIndexById(1);
        //System.out.println(firstIndex);
    }
}