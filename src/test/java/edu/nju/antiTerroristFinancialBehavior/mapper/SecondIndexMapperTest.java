package edu.nju.antiTerroristFinancialBehavior.mapper;

import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SecondIndexMapperTest {

    @Autowired
    private SecondIndexMapper secondIndexMapper;

    @Test
    public void testUpdateSecondIndex(){
        SecondIndex secondIndex = secondIndexMapper.findSecondIndexById(20);

        secondIndex.setDesc("二级指标--更新测试");

        secondIndexMapper.updateSecondIndex(secondIndex);
    }

    @Test
    public void deleteSecondIndex(){
        secondIndexMapper.deleteSecondIndex(22);
    }

}