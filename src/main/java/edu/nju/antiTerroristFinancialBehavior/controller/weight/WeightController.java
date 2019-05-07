package edu.nju.antiTerroristFinancialBehavior.controller.weight;

import edu.nju.antiTerroristFinancialBehavior.utils.AHP;
import edu.nju.antiTerroristFinancialBehavior.utils.Algorithm;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * 权重值· 控制器
 * 所有与定权相关的controller处理
 *
 * @author fanleehao on 2019/4/10
 */

@Controller
public class WeightController {


    @RequestMapping(value = "/saveMarkWeight",method = RequestMethod.POST)
    public String saveMarkWeight(HttpServletRequest request, @RequestParam("indexId") Integer indexId, Model model) {
        //生成一半的矩阵
        String[][] matrix = Algorithm.generateMatrix(request);
        //生成完整的矩阵
        Algorithm.completeMatrix(matrix);
        //矩阵内容转成double
        double[][] m = Algorithm.str2double(matrix);
        //生成每个指标的权重
        double[] weightResult = null;
        AHP ahp = new AHP();//不能是单例的
        if (ahp.isConsistency(m)) {
            weightResult = ahp.getWeight();
            model.addAttribute("flag", 1);
        } else {
            model.addAttribute("flag", 0);
        }
        System.out.println(Arrays.toString(weightResult));
        return "forward:/everyIndexMark?indexId="+indexId;
    }
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