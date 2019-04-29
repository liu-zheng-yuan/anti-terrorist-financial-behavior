package edu.nju.antiTerroristFinancialBehavior.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 可在此测试controller功能
 *
 *  @author fanleehao on 2019/4/10
 *
 */

@Controller
public class TestController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}