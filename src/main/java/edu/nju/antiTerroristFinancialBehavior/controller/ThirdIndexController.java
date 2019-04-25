package edu.nju.antiTerroristFinancialBehavior.controller;

import edu.nju.antiTerroristFinancialBehavior.mapper.ThirdIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.service.ThirdIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 三级指标控制
 *
 * @author fanleehao on 2019/4/25
 */


@Controller
public class ThirdIndexController {

    @Autowired
    private ThirdIndexService thirdIndexService;

    /**
     * 跳转二级指标编辑
     * @param thirdIndexId
     * @return
     */
    @RequestMapping("/thirdIndex/indexEdit/{thirdIndexId}")
    public String toIndexEdit(@PathVariable("thirdIndexId") Integer thirdIndexId, Model model){
        ThirdIndex thirdIndex = thirdIndexService.findThirdIndexById(thirdIndexId);
        model.addAttribute("thirdIndex", thirdIndex);
        //跳转二级编辑页面
        return "thirdIndexEdit";
    }

    /**
     * 执行更新跳转
     * @param thirdIndex
     * @return
     */
    @PostMapping("/thirdIndex/update/")
    public String indexUpdate(ThirdIndex thirdIndex){
        //System.out.println(thirdIndex);
        thirdIndexService.updateThirdIndex(thirdIndex);

        return "redirect:/weightList/" + thirdIndex.getId();
    }

    /**
     * 删除，----级联操作
     * @param id
     * @return
     */
    @RequestMapping("/thirdIndex/delete/{thirdIndexId}")
    public String indexDelete(@PathVariable("thirdIndexId") Integer id){
        ThirdIndex thirdIndex = thirdIndexService.findThirdIndexById(id);
        if(thirdIndex != null) {
            thirdIndexService.deleteThirdIndex(id);
        }
        return "redirect:/weightList/34";
    }
}
