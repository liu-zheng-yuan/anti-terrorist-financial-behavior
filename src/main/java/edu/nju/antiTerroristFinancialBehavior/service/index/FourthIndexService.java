package edu.nju.antiTerroristFinancialBehavior.service.index;

import edu.nju.antiTerroristFinancialBehavior.mapper.FourthIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @desc 控制四级指标的相关逻辑实现
 * @author fanleehao on 2019/4/29
 */

@Service
public class FourthIndexService {

    @Autowired
    private FourthIndexMapper fourthIndexMapper;

    public List<FourthIndex> findFourthIndicesByThirdIndexId(Integer thirdIndexId) {
        return fourthIndexMapper.findFourthIndicesByThirdIndexId(thirdIndexId);
    }

    public FourthIndex findFourthIndexById(Integer id) {
        return fourthIndexMapper.findFourthIndexById(id);
    }

    /**
     * 更新
     * @param fourthIndex
     * @return
     */
    public FourthIndex updateFourthIndex(FourthIndex fourthIndex) {
        FourthIndex oldFourthIndex = fourthIndexMapper.findFourthIndexById(fourthIndex.getId());

        oldFourthIndex.setIndex_name(fourthIndex.getIndex_name());
        oldFourthIndex.setDesc(fourthIndex.getDesc());
        oldFourthIndex.setDimension(fourthIndex.getDimension());
        oldFourthIndex.setNormalize(fourthIndex.getNormalize());
        oldFourthIndex.setRange(fourthIndex.getRange());
        oldFourthIndex.setType(fourthIndex.getType());
        oldFourthIndex.setWeight_num(fourthIndex.getWeight_num());
        oldFourthIndex.setWeight_deno(fourthIndex.getWeight_deno());
        //System.out.println(oldFourthIndex);


        //System.out.println(oldFourthIndex.getFirstIndex());
        fourthIndexMapper.updateFourthIndex(oldFourthIndex);
        return oldFourthIndex;
    }

    /**
     * 新增
     * @param fourthIndex
     */
    public void addFourthIndex(FourthIndex fourthIndex) {
        fourthIndexMapper.addFourthIndex(fourthIndex);
    }

    /**
     * 删除
     * @param fourthIndexId
     */
    public void deleteFourthIndexById(Integer fourthIndexId) {
        fourthIndexMapper.deleteFourthIndexById(fourthIndexId);
    }
}
