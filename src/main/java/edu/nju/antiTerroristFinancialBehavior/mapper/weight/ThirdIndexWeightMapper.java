package edu.nju.antiTerroristFinancialBehavior.mapper.weight;

import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.model.weight.ThirdIndexWeight;

import java.util.List;

public interface ThirdIndexWeightMapper {

    List<Double> findAllWeight(ThirdIndex thirdIndex);

    void insertWeight(ThirdIndexWeight thirdIndexWeight);

    List<Double> findWeight(Integer thirdIndexId, Integer professor);
}
