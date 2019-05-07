package edu.nju.antiTerroristFinancialBehavior.controller.weight;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String saveMarkWeight(HttpServletRequest request) {
        System.out.println(request.getParameter("0+0"));
        System.out.println(request.getParameter("length"));
        return "1";
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