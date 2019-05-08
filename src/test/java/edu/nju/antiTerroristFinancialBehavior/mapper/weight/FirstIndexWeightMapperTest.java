package edu.nju.antiTerroristFinancialBehavior.mapper.weight;

import edu.nju.antiTerroristFinancialBehavior.mapper.FirstIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.weight.FirstIndexWeight;
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
public class FirstIndexWeightMapperTest {
    @Autowired
    FirstIndexWeightMapper firstIndexWeightMapper;
    @Autowired
    FirstIndexMapper firstIndexMapper;

    @Test
    public void insertWeight(){
        FirstIndexWeight firstIndexWeight = new FirstIndexWeight();
        FirstIndex firstIndex = firstIndexMapper.findFirstIndexById(4);
        firstIndexWeight.setFirst_index(firstIndex);
        firstIndexWeight.setProfessor(1);
        firstIndexWeight.setWeight(0.9999);
        firstIndexWeightMapper.insertWeight(firstIndexWeight);
    }
    @Test
    public void findAllWeight(){
        FirstIndex firstIndex = firstIndexMapper.findFirstIndexById(4);
        List<Double> list = firstIndexWeightMapper.findAllWeight(firstIndex);
        System.out.println(list.toString());
    }
    @Test
    public void findWeight(){
        List<Double> list = firstIndexWeightMapper.findWeight(4, 1);
        System.out.println(list.toString());
    }
}