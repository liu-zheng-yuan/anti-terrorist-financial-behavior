package edu.nju.antiTerroristFinancialBehavior.mapper.matrix;

import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.matrix.FirstIndexMatrix;

import java.util.List;

public interface FirstIndexMatrixMapper {
    List<String> findAllMatrix(FirstIndex first_index);

    void insertMatrix(FirstIndexMatrix secondIndexMatrix);
}
