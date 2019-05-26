package edu.nju.antiTerroristFinancialBehavior.service.index;

import edu.nju.antiTerroristFinancialBehavior.mapper.FourthIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.SecondIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.ThirdIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.weight.FirstIndexWeightMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.weight.FourthIndexWeightMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.weight.SecondIndexWeightMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.weight.ThirdIndexWeightMapper;
import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.model.weight.FourthIndexWeight;
import edu.nju.antiTerroristFinancialBehavior.model.weight.SecondIndexWeight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 三级指标业务逻辑处理
 *
 * @author fanleehao on 2019/4/25
 */

@Service
public class ThirdIndexService {

    @Autowired
    private ThirdIndexMapper thirdIndexMapper;
    @Autowired
    private SecondIndexMapper secondIndexMapper;
    @Autowired
    private FourthIndexWeightMapper fourthIndexWeightMapper;
    @Autowired
    private ThirdIndexWeightMapper thirdIndexWeightMapper;
    @Autowired
    private SecondIndexWeightMapper secondIndexWeightMapper;
    @Autowired
    private FirstIndexWeightMapper firstIndexWeightMapper;
    /**
     * 查询三级指标
     * @param thirdIndexId
     * @return
     */
    public ThirdIndex findThirdIndexById(Integer thirdIndexId) {
        return thirdIndexMapper.findThirdIndexById(thirdIndexId);
    }

    /**
     * 更新三级指标
     * @param thirdIndex
     */
    public void updateThirdIndex(ThirdIndex thirdIndex) {
        thirdIndexMapper.updateThirdIndex(thirdIndex);
        return;
    }

    /**
     * 删除三级指标, 同时所属四级指标级联删除
     * @param id
     */
    public void deleteThirdIndex(Integer id) {
        thirdIndexMapper.deleteThirdIndex(id);
    }

    /**
     * 新增
     * @param thirdIndex
     */
    public void addThirdIndex(ThirdIndex thirdIndex) {
        thirdIndexMapper.addThirdIndex(thirdIndex);
    }

    public List<ThirdIndex> findThirdIndicesBySecondIndexId(Integer secondIndexId) {
        return thirdIndexMapper.findThirdIndicesBySecondIndexId(secondIndexId);
    }

    /**
     * 获得一个三级指标下属所有四级指标的最终权重
     * @param thirdIndexId
     */
    public List<FourthIndexWeight> getAllFourthIndexWeights(Integer thirdIndexId) {
        //找到三级指标下属所有四级指标
        List<FourthIndex> fourthIndices = thirdIndexMapper.findFourthIndicesByThirdIndexId(thirdIndexId);
        List<FourthIndexWeight> res = new ArrayList<>();
        for (FourthIndex f : fourthIndices) {
            FourthIndexWeight finalWeight = fourthIndexWeightMapper.findFinalWeight(f);
            finalWeight.getFourth_index().setIndex_name(f.getIndex_name());
            if (finalWeight != null) {
                res.add(finalWeight);
            }
        }
        return res;
    }

    /**
     * 计算最终的四级指标的权重
     * @param thirdIndexId
     */
    public void calculateFinalWeight(Integer thirdIndexId) {
        //找到三级指标下属所有四级指标
        List<FourthIndex> fourthIndices = thirdIndexMapper.findFourthIndicesByThirdIndexId(thirdIndexId);
        List<FourthIndexWeight> res = new ArrayList<>();
        for (FourthIndex f : fourthIndices) {
            //找到该四级指标所属三级指标、二级指标、一级指标
            ThirdIndex thirdIndex = new ThirdIndex();
            SecondIndex secondIndex = new SecondIndex();
            FirstIndex firstIndex = new FirstIndex();
            thirdIndex.setId(thirdIndexId);
            secondIndex.setId(thirdIndexMapper.getThirdIndexParentId(thirdIndexId));
            firstIndex.setId(secondIndexMapper.getSecondIndexParentId(secondIndex.getId()));
            f.setThirdIndex(thirdIndex);
            f.setSecondIndex(secondIndex);
            f.setFirstIndex(firstIndex);

            //对于每个四级指标,找到每个专家给它评分的平均值
            List<Double> fourthWeights = fourthIndexWeightMapper.findAllWeight(f);
            Double fourthAvg = average(fourthWeights);
            //找到对应三级指标的平均权重
            List<Double> thirdWeights = thirdIndexWeightMapper.findAllWeight(f.getThirdIndex());
            Double thirdAvg = average(thirdWeights);
            //找到对应二级指标的平均权重
            List<Double> secondWeights = secondIndexWeightMapper.findAllWeight(f.getSecondIndex());
            Double secondAvg = average(secondWeights);
            //找到对应一级指标的平均权重
            List<Double> firstWeights = firstIndexWeightMapper.findAllWeight(f.getFirstIndex());
            Double firstAvg = average(firstWeights);
            //每一级权重相乘,算出最终的四级权重
            Double finalFourthWeight = fourthAvg * thirdAvg * secondAvg * firstAvg;
            FourthIndexWeight newFourthIndexWeight = new FourthIndexWeight();
            newFourthIndexWeight.setFourth_index(f);
            newFourthIndexWeight.setWeight(finalFourthWeight);
            res.add(newFourthIndexWeight);
        }
        //将计算出来的四级指标最终权重插入到表里
        for (FourthIndexWeight f : res) {
            fourthIndexWeightMapper.insertFinalWeight(f);
        }
    }

    public Double average(List<Double> weights){
        if (weights == null || weights.size() == 0) {
            return 0.0;
        }
        Double sum = 0.0;
        for (Double w : weights) {
            sum += w;
        }
        Double avg = sum / weights.size();
        return avg;
    }
}
