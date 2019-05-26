package edu.nju.antiTerroristFinancialBehavior.mapper.weight;

import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.weight.FourthIndexWeight;

import java.util.List;

public interface FourthIndexWeightMapper {
    List<Double> findAllWeight(FourthIndex fourthIndex);

    void insertWeight(FourthIndexWeight fourthIndexWeight);

    List<Double> findWeight(Integer fourthIndexId, Integer professor);

    //插入最终权重到result表里
    void insertFinalWeight(FourthIndexWeight fourthIndexWeight);

    //在result表中找到每个指标的最终权重
    FourthIndexWeight findFinalWeight(FourthIndex fourthIndex);

}
