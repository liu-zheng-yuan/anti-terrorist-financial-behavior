package edu.nju.antiTerroristFinancialBehavior.controller.weight;

import edu.nju.antiTerroristFinancialBehavior.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 权重值· 控制器
 * 所有与定权相关的controller处理
 *
 * @author fanleehao on 2019/4/10
 */

@Controller
public class WeightController {

    @Autowired
    private IndexService indexService;

    /**
     * 指标定权---矩阵
     */
    @RequestMapping("/weightMatrix")
    public String weightMatrix(){
        return "weight/weightMatrix";
    }


    @RequestMapping("/marking")
    public String Marking() {return "weight/marking";}




}