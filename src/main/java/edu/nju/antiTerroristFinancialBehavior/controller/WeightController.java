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

    /**
     * 指标定权---矩阵
     */
    @RequestMapping("/weightMatrix")
    public String weightMatrix(){
        return "weightMatrix";
    }


    @RequestMapping("/modelDisplay")
    public String modelDisplay() {return "modelDisplay";}

    @RequestMapping("/resultCalculate")
    public String resultCalculate() {return "resultCalculate";}

    @RequestMapping("/Marking")
    public String Marking() {return "Marking";}

    @RequestMapping("/index")
    public String index() {return "index"; }

    @RequestMapping("/Score")
    public String Score() {return "Score";}

    @RequestMapping("/result")
    public String result() {return "result";}

    @RequestMapping("/model")
    public String model() {return "model";}
}
