package edu.nju.antiTerroristFinancialBehavior.controller;

import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 权重值·
 *
 * @author fanleehao on 2019/4/10
 */

@Controller
public class WeightController {

    @Autowired
    private IndexService indexService;

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
     * 根据二级指标，列举三级指标
     * @param secondIndexId
     * @return
     */
    @GetMapping("/weightList/{secondIndexId}")
    public String loadThirdIndex(@PathVariable("secondIndexId") Integer secondIndexId, Model model){
        List<ThirdIndex> thirdIndices = indexService.findThirdIndicesBySecondIndexId(secondIndexId);
/*        for (ThirdIndex thirdIndex : thirdIndices) {
            System.out.println(thirdIndex);
        }*/

        model.addAttribute("thirdIndices", thirdIndices);
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