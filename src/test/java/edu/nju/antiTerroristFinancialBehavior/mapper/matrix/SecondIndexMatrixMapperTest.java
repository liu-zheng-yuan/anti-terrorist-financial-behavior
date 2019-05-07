package edu.nju.antiTerroristFinancialBehavior.mapper.matrix;

import edu.nju.antiTerroristFinancialBehavior.mapper.SecondIndexMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.model.matrix.SecondIndexMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SecondIndexMatrixMapperTest {
    @Autowired
    SecondIndexMatrixMapper secondIndexMatrixMapper;
    @Autowired
    SecondIndexMapper secondIndexMapper;

    @Test
    public void insertMatrix(){
        SecondIndexMatrix secondIndexMatrix = new SecondIndexMatrix();
        SecondIndex secondIndex = secondIndexMapper.findSecondIndexById(15);

        secondIndexMatrix.setSecond_index(secondIndex);
        secondIndexMatrix.setProfessor(1);
        secondIndexMatrix.setMatrix("1234");

        secondIndexMatrixMapper.insertMatrix(secondIndexMatrix);
    }
    @Test
    public void findAllMatrix(){
        SecondIndex secondIndex = secondIndexMapper.findSecondIndexById(15);
        List<String> res = secondIndexMatrixMapper.findAllMatrix(secondIndex);
        System.out.println(res.toString());
    }
}