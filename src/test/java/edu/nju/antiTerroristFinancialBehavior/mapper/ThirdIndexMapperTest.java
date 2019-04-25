package edu.nju.antiTerroristFinancialBehavior.mapper;

import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
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
public class ThirdIndexMapperTest {

    @Autowired
    ThirdIndexMapper thirdIndexMapper;

    @Test
    public void findThirdIndexById(){
        ThirdIndex thirdIndex = thirdIndexMapper.findThirdIndexById(34);
        System.out.println(thirdIndex);
        System.out.println(thirdIndex.getSecond_index());
    }

    @Test
    public void updateThirdIndex(){
        ThirdIndex thirdIndex = thirdIndexMapper.findThirdIndexById(34);
        thirdIndex.setDesc("三级指标--测试");
        thirdIndexMapper.updateThirdIndex(thirdIndex);
    }

    @Test
    public void deleteteThirdIndex(){
        thirdIndexMapper.deleteThirdIndex(54);
    }


}