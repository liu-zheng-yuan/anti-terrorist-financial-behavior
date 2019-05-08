package edu.nju.antiTerroristFinancialBehavior.mapper.matrix;

import edu.nju.antiTerroristFinancialBehavior.model.matrix.ZeroIndexMatrix;
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
public class ZeroIndexMatrixMapperTest {

    @Autowired
    ZeroIndexMatrixMapper zeroIndexMatrixMapper;

    @Test
    public void insertMatrix(){
        ZeroIndexMatrix zeroIndexMatrix = new ZeroIndexMatrix();
        zeroIndexMatrix.setProfessor(1);
        zeroIndexMatrix.setMatrix("1,2,3,4,5,6");
        zeroIndexMatrixMapper.insertMatrix(zeroIndexMatrix);
    }

    @Test
    public void findAllMatrix(){
        List<String> list = zeroIndexMatrixMapper.findAllMatrix();
        System.out.println(list.toString());
    }

    @Test
    public void findMatrix(){
        System.out.println(zeroIndexMatrixMapper.findMatrix(1));
    }
}