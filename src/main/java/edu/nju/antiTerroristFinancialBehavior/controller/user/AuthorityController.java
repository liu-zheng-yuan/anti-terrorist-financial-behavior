package edu.nju.antiTerroristFinancialBehavior.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户控制--Delay至V2.0
 *
 * @author fanleehao on 2019/4/10
 */

@Controller
public class AuthorityController {


    /**
     * 登录
     */
    @RequestMapping("/loginUI")
    public String loginUI(){
        return "loginUI";
    }
}
