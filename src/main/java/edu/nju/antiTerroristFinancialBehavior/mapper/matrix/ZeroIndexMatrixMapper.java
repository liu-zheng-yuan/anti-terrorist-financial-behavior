package edu.nju.antiTerroristFinancialBehavior.mapper.matrix;

import edu.nju.antiTerroristFinancialBehavior.model.matrix.ZeroIndexMatrix;

import java.util.List;

public interface ZeroIndexMatrixMapper {
    List<String> findAllMatrix();

    void insertMatrix(ZeroIndexMatrix zeroIndexMatrix);

    String findMatrix(Integer professor);
}
