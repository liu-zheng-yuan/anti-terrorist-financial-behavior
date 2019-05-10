package edu.nju.antiTerroristFinancialBehavior.service.index;

import edu.nju.antiTerroristFinancialBehavior.mapper.ThirdIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.weight.FirstIndexWeightMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.weight.FourthIndexWeightMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.weight.SecondIndexWeightMapper;
import edu.nju.antiTerroristFinancialBehavior.mapper.weight.ThirdIndexWeightMapper;
import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.model.weight.FourthIndexWeight;
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
     * 获得一个三级指标下属所有四级指标的最终多个专家平均权重
     * @param thirdIndexId
     */
    //todo 计算最终权重的代码
    public List<FourthIndexWeight> getAllFourthIndexWeights(Integer thirdIndexId) {
        //找到三级指标下属所有四级指标
        List<FourthIndex> fourthIndices = thirdIndexMapper.findFourthIndicesByThirdIndexId(thirdIndexId);
        List<FourthIndexWeight> res = new ArrayList<>();
        for (FourthIndex f : fourthIndices) {
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
        return res;
        //todo 把上面的功能整合到点击计算按钮里面。然后下面写如何从最终权重表里读出并展示。
    }
    public Double average(List<Double> weights){
        Double sum = 0.0;
        for (Double w : weights) {
            sum += w;
        }
        Double avg = sum / weights.size();
        return avg;
    }
}
