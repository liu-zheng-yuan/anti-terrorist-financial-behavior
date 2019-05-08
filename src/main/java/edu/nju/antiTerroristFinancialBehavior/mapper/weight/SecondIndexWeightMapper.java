package edu.nju.antiTerroristFinancialBehavior.mapper.weight;

import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.model.weight.SecondIndexWeight;

import java.util.List;

public interface SecondIndexWeightMapper {
    List<Double> findAllWeight(SecondIndex second_index);

    void insertWeight(SecondIndexWeight secondIndexWeight);
}
