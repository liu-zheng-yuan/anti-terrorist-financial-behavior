package edu.nju.antiTerroristFinancialBehavior.controller.weight;

import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 列举四级指标
     * 后续修改：根据不同等级指标的参数，
     * 使用模型返回不同的指标子集
     */
    @RequestMapping("/weightList")
    public String weightList(){
        return "index/indexList";
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

    @RequestMapping("/Score")
    public String Score() {return "Score";}

    @RequestMapping("/result")
    public String result() {return "result";}

    @RequestMapping("/model")
    public String model() {return "model";}
}