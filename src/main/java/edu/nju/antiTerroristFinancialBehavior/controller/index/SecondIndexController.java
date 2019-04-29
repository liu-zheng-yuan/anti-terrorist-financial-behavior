package edu.nju.antiTerroristFinancialBehavior.controller.index;

import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.service.IndexService;
import edu.nju.antiTerroristFinancialBehavior.service.SecondIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 二级指标控制处理
 *
 * @author fanleehao on 2019/4/25
 */

@Controller
public class SecondIndexController {

    @Autowired
    private SecondIndexService secondIndexService;
    @Autowired
    private IndexService indexService;

    /**
     * 跳转二级指标编辑
     * @param secondIndexId
     * @return
     */
    @RequestMapping("/secondIndex/indexEdit/{secondIndexId}")
    public String toWeightEdit(@PathVariable("secondIndexId") Integer secondIndexId, Model model){
        SecondIndex secondIndex = secondIndexService.findSecondIndexById(secondIndexId);
        model.addAttribute("secondIndex", secondIndex);
        //跳转二级编辑页面
        return "index/secondIndexEdit";
    }

    /**
     * 执行更新逻辑
     * @param secondIndex
     * @return
     */
    @PostMapping("/secondIndex/update")
    public String indexUpdate(SecondIndex secondIndex){
        //System.out.println(secondIndex);
        secondIndexService.updateSecondIndex(secondIndex);

        return "redirect:/index/list/34";
    }


    /**
     * 增加指标（可以增加二级、三级、四级指标）
     * @param secondIndex
     * @return
     */
    @PostMapping("/secondIndex/add")
    public String weightAdd2(SecondIndex secondIndex, @RequestParam("parentIndexId")String parentIndexId) {
        //找到二级指标所属一级指标的id
        FirstIndex firstIndex = new FirstIndex();
        firstIndex.setId(Integer.valueOf(parentIndexId));
        secondIndex.setFirst_index(firstIndex);
        indexService.addSecondIndex(secondIndex);
        return "redirect:/index/list/34";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("secondIndex/delete/{secondIndexId}")
    public String indexDelete(@PathVariable("secondIndexId") Integer id){
        SecondIndex secondIndex = secondIndexService.findSecondIndexById(id);
        if (secondIndex != null){
            secondIndexService.deleteSecondIndex(id);
        }
        return "redirect:/index/list/34";
    }
}
