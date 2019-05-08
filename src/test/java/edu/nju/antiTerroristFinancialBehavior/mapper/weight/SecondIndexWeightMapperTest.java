package edu.nju.antiTerroristFinancialBehavior.mapper.weight;

import edu.nju.antiTerroristFinancialBehavior.mapper.SecondIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.model.weight.SecondIndexWeight;
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
public class SecondIndexWeightMapperTest {
    @Autowired
    SecondIndexWeightMapper secondIndexWeightMapper;
    @Autowired
    SecondIndexMapper secondIndexMapper;

    @Test
    public void insertWeight(){
        SecondIndexWeight secondIndexWeight = new SecondIndexWeight();
        SecondIndex secondIndex = secondIndexMapper.findSecondIndexById(15);

        secondIndexWeight.setSecond_index(secondIndex);
        secondIndexWeight.setProfessor(1);
        secondIndexWeight.setWeight(0.3456);

        secondIndexWeightMapper.insertWeight(secondIndexWeight);

    }
    @Test
    public void findAllWeight(){
        SecondIndex secondIndex = secondIndexMapper.findSecondIndexById(15);
        List<Double> list = secondIndexWeightMapper.findAllWeight(secondIndex);
        System.out.println(list.toString());
    }

}