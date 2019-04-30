package edu.nju.antiTerroristFinancialBehavior.controller.user;

import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.MenuItem;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.service.CommonIndexService;
import edu.nju.antiTerroristFinancialBehavior.service.index.FourthIndexService;
import edu.nju.antiTerroristFinancialBehavior.service.index.SecondIndexService;
import edu.nju.antiTerroristFinancialBehavior.service.index.ThirdIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    CommonIndexService commonIndexService;

    @Autowired
    private SecondIndexService secondIndexService;
    @Autowired
    private ThirdIndexService thirdIndexService;
    @Autowired
    private FourthIndexService fourthIndexService;
//
//    @RequestMapping("/weightMatrix")
//    public String weightMatrix(){
//        return "weightMatrix";
//    }
//
//
//    @RequestMapping("/modelDisplay")
//    public String modelDisplay() {return "modelDisplay";}
//
//    @RequestMapping("/resultCalculate")
//    public String resultCalculate() {return "resultCalculate";}
//
//    @RequestMapping("/Marking")
//    public String Marking() {return "Marking";}
//
//
//
//    @RequestMapping("/Score")
//    public String Score() {return "Score";}
//
//    @RequestMapping("/result")
//    public String result() {return "result";}
//
//    @RequestMapping("/model")
//    public String model() {return "model";}
    /**
     * “用户”访问时能看到的主页
     * @param
     * @return
     */
    @RequestMapping("/indexUser")
    public String index() {
        //“用户”权限所有的页面放在User文件夹下
        return "user/indexUser";
    }

    /**
     * ("用户"访问时)根据三级指标，列举四级指标，无增删功能
     * @param thirdIndexId
     * @return
     */
    @GetMapping("/indexListUser/{thirdIndexId}")
    public String loadThirdIndex(@PathVariable("thirdIndexId") Integer thirdIndexId, Model model){

        List<FourthIndex> fourthIndices = fourthIndexService.findFourthIndicesByThirdIndexId(thirdIndexId);


        ThirdIndex curThirdIndex = thirdIndexService.findThirdIndexById(thirdIndexId);
        SecondIndex curSecondIndex = curThirdIndex.getSecond_index();


        model.addAttribute("fourthIndices", fourthIndices);
        model.addAttribute("curThirdIndex", curThirdIndex);
        model.addAttribute("curSecondIndex", curSecondIndex);

        return "user/indexListUser";
    }
    /**
     * ("用户"访问时)返回指标封装之后的zTree对象，可以点击跳转
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/loadMenuUser/{parentID}")
    public List<MenuItem> loadMenu(@PathVariable("parentID") Integer id){
        return commonIndexService.findMenusItemsByParentIDUser(id);
    }
}
