package edu.nju.antiTerroristFinancialBehavior.controller.index;

import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.service.IndexService;
import edu.nju.antiTerroristFinancialBehavior.service.ThirdIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 三级指标控制
 *
 * @author fanleehao on 2019/4/25
 */


@Controller
public class ThirdIndexController {

    @Autowired
    private ThirdIndexService thirdIndexService;
    @Autowired
    private IndexService indexService;

    /**
     * 增加指标（可以增加二级、三级、四级指标）
     * @param thirdIndex
     * @return
     */
    @PostMapping("/thirdIndex/add")
    public String weightAdd3(ThirdIndex thirdIndex, @RequestParam("parentIndexId")String parentIndexId) {
        //找到三级指标所属的二级指标的id
        SecondIndex secondIndex = new SecondIndex();
        secondIndex.setId(Integer.valueOf(parentIndexId));
        //找到二级指标所属的一级指标的id
        int firstIndexId = indexService.getSecondIndexParentId(Integer.valueOf(parentIndexId));
        FirstIndex firstIndex = new FirstIndex();
        firstIndex.setId(firstIndexId);
        //装配
        thirdIndex.setFirst_index(firstIndex);
        thirdIndex.setSecond_index(secondIndex);
        indexService.addThirdIndex(thirdIndex);
        return "redirect:/index/list/34";
    }



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
        return "index/thirdIndexEdit";
    }

    /**
     * 执行更新
     * @param thirdIndex
     * @return
     */
    @PostMapping("/thirdIndex/update/")
    public String indexUpdate(ThirdIndex thirdIndex){
        //System.out.println(thirdIndex);
        thirdIndexService.updateThirdIndex(thirdIndex);

        return "redirect:/index/list/" + thirdIndex.getId();
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
        return "redirect:/index/list/34";
    }


}
