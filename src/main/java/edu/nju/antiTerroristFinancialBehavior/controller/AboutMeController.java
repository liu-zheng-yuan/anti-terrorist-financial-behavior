package edu.nju.antiTerroristFinancialBehavior.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Index控制
 *
 * @author fanleehao on 2019/4/10
 */


@Controller
public class AboutMeController {

    @RequestMapping("/homePage")
    public String weightList(){
//        System.out.println("Aboutme....");
        return "homePage";
    }
}
