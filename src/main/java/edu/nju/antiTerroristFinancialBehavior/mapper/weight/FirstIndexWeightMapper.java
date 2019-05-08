package edu.nju.antiTerroristFinancialBehavior.mapper.weight;

import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.weight.FirstIndexWeight;

import java.util.List;

public interface FirstIndexWeightMapper {
    List<Double> findAllWeight(FirstIndex firstIndex);

    void insertWeight(FirstIndexWeight firstIndexWeight);

    List<Double> findWeight(Integer firstIndexId, Integer professor);

}


