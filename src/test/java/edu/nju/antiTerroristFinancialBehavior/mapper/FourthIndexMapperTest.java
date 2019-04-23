package edu.nju.antiTerroristFinancialBehavior.mapper;

import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
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
public class FourthIndexMapperTest {

    @Autowired
    FourthIndexMapper fourthIndexMapper;

    @Test
    public void findFourthIndexById(){
        FourthIndex fourthIndexById = fourthIndexMapper.findFourthIndexById(158);
        System.out.println(fourthIndexById);
        System.out.println(fourthIndexById.getFirstIndex());
        System.out.println(fourthIndexById.getSecondIndex());
        System.out.println(fourthIndexById.getThirdIndex());
    }

    @Test
    public void updateFourthIndex(){
        FourthIndex fourthIndex = fourthIndexMapper.findFourthIndexById(158);
        System.out.println(fourthIndex);
        fourthIndex.setDimension("test" + fourthIndex.getDimension());
        fourthIndex.setDesc("test" + fourthIndex.getDesc());
        fourthIndexMapper.updateFourthIndex(fourthIndex);
    }


    @Test
    public void deleteFourthIndexById(){
        Integer id = 158;
        FourthIndex fourthIndex = fourthIndexMapper.findFourthIndexById(id);
        if (fourthIndex != null){
            fourthIndexMapper.deleteFourthIndexById(id);
        }
    }
}