package edu.nju.antiTerroristFinancialBehavior.controller.result;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 评分结果
 *
 * @author fanleehao on 2019/4/29
 */

@Controller
public class ResultController {

    @RequestMapping("/resultCalculate")
    public String resultCalculate() {return "result/resultCalculate";}


    @RequestMapping("/result")
    public String result() {return "result/result";}


    @RequestMapping("/score")
    public String Score() {return "result/score";}
}
