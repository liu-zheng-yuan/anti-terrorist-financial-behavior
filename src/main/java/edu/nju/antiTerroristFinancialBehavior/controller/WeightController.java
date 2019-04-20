package edu.nju.antiTerroristFinancialBehavior.controller;

import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
     * 列举四级指标
     * 后续修改：根据不同等级指标的参数，
     * 使用模型返回不同的指标子集
     */
    @RequestMapping("/weightList")
    public String weightList(){
        return "weightList";
    }

    /**
     * 根据三级指标，列举四级指标
     * @param thirdIndexId
     * @return
     */
    @GetMapping("/weightList/{thirdIndexId}")
    public String loadThirdIndex(@PathVariable("thirdIndexId") Integer thirdIndexId, Model model){
//        List<ThirdIndex> thirdIndices = indexService.findThirdIndicesBySecondIndexId(thirdIndexId);
/*        for (ThirdIndex thirdIndex : thirdIndices) {
            System.out.println(thirdIndex);
        }*/

        List<FourthIndex> fourthIndices = indexService.findFourthIndicesByThirdIndexId(thirdIndexId);
       /* for (FourthIndex fourthIndex: fourthIndices) {
            System.out.println(fourthIndex);
        }*/

        model.addAttribute("fourthIndices", fourthIndices);
        return "weightList";
    }



    /**
     * 编辑指标
     */
    @RequestMapping("/weightEdit/{fourthIndexId}")
    public String weightEdit(Model model, @PathVariable("fourthIndexId") Integer id){
        FourthIndex fourthIndex = indexService.findFourthIndexById(id);
        model.addAttribute("fourthIndex", fourthIndex);
        return "weightEdit";
    }

    /**
     * 更新指标
     * @param fourthIndex
     * @return
     */
    @PostMapping("/weightUpdate")
    public String weightUpdate(FourthIndex fourthIndex){
        System.out.println(fourthIndex);


        //返回主页
        return "index";
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