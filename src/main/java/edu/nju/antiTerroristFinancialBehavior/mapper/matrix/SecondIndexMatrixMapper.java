package edu.nju.antiTerroristFinancialBehavior.mapper.matrix;

import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.model.matrix.SecondIndexMatrix;

import java.util.List;

public interface SecondIndexMatrixMapper {
    List<String> findAllMatrix(SecondIndex second_index);

    void insertMatrix(SecondIndexMatrix secondIndexMatrix);
}
