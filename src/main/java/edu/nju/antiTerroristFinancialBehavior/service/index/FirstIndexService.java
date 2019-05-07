package edu.nju.antiTerroristFinancialBehavior.service.index;

import edu.nju.antiTerroristFinancialBehavior.mapper.FirstIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fanleehao on 2019/4/30
 */

@Service
public class FirstIndexService {

    @Autowired
    private FirstIndexMapper firstIndexMapper;

    public FirstIndex findFirstIndexById(Integer id) {
        return firstIndexMapper.findFirstIndexById(id);
    }

}
