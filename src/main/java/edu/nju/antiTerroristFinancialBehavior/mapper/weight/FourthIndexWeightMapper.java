package edu.nju.antiTerroristFinancialBehavior.mapper.weight;

import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.weight.FourthIndexWeight;

import java.util.List;

public interface FourthIndexWeightMapper {
    List<Double> findAllWeight(FourthIndex fourthIndex);

    void insertWeight(FourthIndexWeight fourthIndexWeight);
}
