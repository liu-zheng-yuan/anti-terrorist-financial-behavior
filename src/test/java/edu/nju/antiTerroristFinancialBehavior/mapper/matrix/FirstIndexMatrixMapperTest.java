package edu.nju.antiTerroristFinancialBehavior.mapper.matrix;

import edu.nju.antiTerroristFinancialBehavior.mapper.FirstIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.matrix.FirstIndexMatrix;
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
public class FirstIndexMatrixMapperTest {
    @Autowired
    FirstIndexMatrixMapper firstIndexMatrixMapper;
    @Autowired
    FirstIndexMapper firstIndexMapper;

    @Test
    public void insertMatrix(){
        FirstIndexMatrix firstIndexMatrix = new FirstIndexMatrix();

        FirstIndex firstIndex = firstIndexMapper.findFirstIndexById(4);

        firstIndexMatrix.setFirst_index(firstIndex);
        firstIndexMatrix.setProfessor(1);
        firstIndexMatrix.setMatrix("123");

        firstIndexMatrixMapper.insertMatrix(firstIndexMatrix);
    }
    @Test
    public void findAllMatrix(){
        FirstIndex firstIndex = firstIndexMapper.findFirstIndexById(4);

        List<String> res = firstIndexMatrixMapper.findAllMatrix(firstIndex);
        System.out.println(res.toString());
    }

    @Test
    public void findMatrix(){
        System.out.println(firstIndexMatrixMapper.findMatrix(4, 1));
    }
}