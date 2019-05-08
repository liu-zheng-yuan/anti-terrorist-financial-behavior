package edu.nju.antiTerroristFinancialBehavior.mapper.matrix;

import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.model.matrix.ThirdIndexMatrix;

import java.util.List;

public interface ThirdIndexMatrixMapper {
    List<String> findAllMatrix(ThirdIndex third_index);

    void insertMatrix(ThirdIndexMatrix thirdIndexMatrix);

    String findMatrix(Integer thirdIndexId, Integer professor);
}
