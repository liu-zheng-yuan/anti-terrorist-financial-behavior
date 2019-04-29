package edu.nju.antiTerroristFinancialBehavior.controller.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模型
 *
 * @author fanleehao on 2019/4/29
 */

@Controller
public class ModelController {

    @RequestMapping("/model")
    public String model() {return "model/model";}

    @RequestMapping("/modelDisplay")
    public String modelDisplay() {return "model/modelDisplay";}
}
