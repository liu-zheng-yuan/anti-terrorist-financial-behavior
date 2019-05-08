package edu.nju.antiTerroristFinancialBehavior.mapper.weight;

import edu.nju.antiTerroristFinancialBehavior.mapper.FourthIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.weight.FourthIndexWeight;
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
public class FourthIndexWeightMapperTest {
    @Autowired
    FourthIndexWeightMapper fourthIndexWeightMapper;
    @Autowired
    FourthIndexMapper fourthIndexMapper;

    @Test
    public void insertWeight(){
        FourthIndexWeight fourthIndexWeight = new FourthIndexWeight();
        FourthIndex fourthIndex = fourthIndexMapper.findFourthIndexById(145);
        fourthIndexWeight.setFourth_index(fourthIndex);
        fourthIndexWeight.setProfessor(1);
        fourthIndexWeight.setWeight(0.654);
        fourthIndexWeightMapper.insertWeight(fourthIndexWeight);
    }

    @Test
    public void findAllWeight(){
        FourthIndex fourthIndex = fourthIndexMapper.findFourthIndexById(145);
        List<Double> list = fourthIndexWeightMapper.findAllWeight(fourthIndex);
        System.out.println(list.toString());
    }

}