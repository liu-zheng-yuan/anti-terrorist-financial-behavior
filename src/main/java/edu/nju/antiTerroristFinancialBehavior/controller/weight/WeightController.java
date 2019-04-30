package edu.nju.antiTerroristFinancialBehavior.controller.weight;

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

/*    @Autowired
    private IndexService indexService;*/

    /**
     * 指标定权---矩阵
     */
    @RequestMapping("/weightMatrix")
    public String weightMatrix(){
        return "weight/weightMatrix";
    }


    @RequestMapping("/weightDisplay")
    public String weightDisplay(){
        return "weight/weightDisplay";
    }

    @RequestMapping("/weightShow")
    public String weightShow(){
        return "weight/weightShow";
    }



}