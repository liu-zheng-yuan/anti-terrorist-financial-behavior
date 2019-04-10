package edu.nju.antiTerroristFinancialBehavior.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 权重值
 *
 * @author fanleehao on 2019/4/10
 */

@Controller
public class WeightController {

    /**
     * 列举三级指标
     * 后续修改：根据不同等级指标的参数，
     * 使用模型返回不同的指标子集
     */
    @RequestMapping("/weightList")
    public String weightList(){
        return "weightList";
    }

    /**
     * 编辑指标
     */
    @RequestMapping("/weightEdit")
    public String weightEdit(){
        return "weightEdit";
    }
}
