package edu.nju.antiTerroristFinancialBehavior.controller.mark;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 评分
 *
 * @author fanleehao on 2019/4/30
 */

@Controller
public class MarkController {


    @RequestMapping("/marking")
    public String marking() {return "mark/marking";}
}
