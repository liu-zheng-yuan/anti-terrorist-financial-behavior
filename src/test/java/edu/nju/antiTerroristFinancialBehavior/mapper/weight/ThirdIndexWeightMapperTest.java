package edu.nju.antiTerroristFinancialBehavior.mapper.weight;

import edu.nju.antiTerroristFinancialBehavior.mapper.ThirdIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.model.weight.ThirdIndexWeight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ThirdIndexWeightMapperTest {
    @Autowired
    ThirdIndexWeightMapper thirdIndexWeightMapper;
    @Autowired
    ThirdIndexMapper thirdIndexMapper;
    @Test
    public void insertWeight(){
        ThirdIndexWeight thirdIndexWeight = new ThirdIndexWeight();
        ThirdIndex thirdIndex = thirdIndexMapper.findThirdIndexById(34);
        thirdIndexWeight.setThird_index(thirdIndex);
        thirdIndexWeight.setProfessor(1);
        thirdIndexWeight.setWeight(0.279);

        thirdIndexWeightMapper.insertWeight(thirdIndexWeight);
    }

    @Test
    public void findAllWeight(){
        ThirdIndex thirdIndex = thirdIndexMapper.findThirdIndexById(34);
        List<Double> list = thirdIndexWeightMapper.findAllWeight(thirdIndex);
        System.out.println(list.toString());
    }

    @Test
    public void  findWeight(){
        List<Double> list = thirdIndexWeightMapper.findWeight(34, 1);
        System.out.println(list.toString());
    }

}