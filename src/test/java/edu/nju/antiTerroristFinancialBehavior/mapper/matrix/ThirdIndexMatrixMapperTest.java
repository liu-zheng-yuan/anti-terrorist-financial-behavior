package edu.nju.antiTerroristFinancialBehavior.mapper.matrix;

import edu.nju.antiTerroristFinancialBehavior.mapper.ThirdIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.model.matrix.ThirdIndexMatrix;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ThirdIndexMatrixMapperTest {

    @Autowired
    ThirdIndexMatrixMapper thirdIndexMatrixMapper;
    @Autowired
    ThirdIndexMapper thirdIndexMapper;

    @Test
    public void insertMatrix(){
        ThirdIndexMatrix thirdIndexMatrix = new ThirdIndexMatrix();

        ThirdIndex thirdIndex = thirdIndexMapper.findThirdIndexById(35);

        thirdIndexMatrix.setThird_index(thirdIndex);
        thirdIndexMatrix.setProfessor(1);
        thirdIndexMatrix.setMatrix("123456");

        thirdIndexMatrixMapper.insertMatrix(thirdIndexMatrix);
    }
    @Test
    public void findAllMatrix(){
        ThirdIndex thirdIndex = thirdIndexMapper.findThirdIndexById(34);

        List<String> res = thirdIndexMatrixMapper.findAllMatrix(thirdIndex);
        System.out.println(res.toString());
    }

    @Test
    public void findMatrix(){
        System.out.println(thirdIndexMatrixMapper.findMatrix(34, 1));
    }
}