package edu.nju.antiTerroristFinancialBehavior.controller.index;

import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.service.index.FourthIndexService;
import edu.nju.antiTerroristFinancialBehavior.service.index.ThirdIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 四级指标Controller
 *
 * @author fanleehao on 2019/4/29
 */


@Controller
public class FourthIndexController {

    @Autowired
    private FourthIndexService fourthIndexService;
    @Autowired
    private ThirdIndexService thirdIndexService;

    /**
     * 编辑四级指标页面转发
     */
    @RequestMapping("/fourthIndex/edit/{fourthIndexId}")
    public String toWeightEdit(Model model, @PathVariable("fourthIndexId") Integer id){
        FourthIndex fourthIndex = fourthIndexService.findFourthIndexById(id);
        model.addAttribute("fourthIndex", fourthIndex);
        //System.out.println("666");
        return "index/fourthIndexEdit";
    }

    /**
     * 更新四级指标
     * @param fourthIndex
     * @return
     */
    @PostMapping("/fourthIndex/update")
    public String weightUpdate(FourthIndex fourthIndex){
        //System.out.println(fourthIndex);

        FourthIndex newFourthIndex = fourthIndexService.updateFourthIndex(fourthIndex);
        //返回主页
        return "redirect:/index/list/" + newFourthIndex.getThirdIndex().getId();
    }

    /**
     * 增加四级指标
     * @param fourthIndex,parentIndexId
     * @return
     */
    @PostMapping("/fouthIndex/add")
    public String indexAdd4(FourthIndex fourthIndex, @RequestParam("parentIndexId")String parentIndexId) {
        //找到四级指标所属三级指标的id
        /*ThirdIndex thirdIndex = new ThirdIndex();
        thirdIndex.setId(Integer.valueOf(parentIndexId));

        //找到三级指标所属二级指标的id
        int secondIndexId = commonIndexService.getThirdIndexParentId(Integer.valueOf(parentIndexId));

        SecondIndex secondIndex = new SecondIndex();
        secondIndex.setId(secondIndexId);
        //找到二级指标所属一级指标的id
        int firstIndexId = commonIndexService.getSecondIndexParentId(secondIndexId);
        FirstIndex firstIndex = new FirstIndex();
        firstIndex.setId(firstIndexId);*/

        //1.查询1/2/3级指标
        ThirdIndex thirdIndex = thirdIndexService.findThirdIndexById(Integer.valueOf(parentIndexId));
        SecondIndex secondIndex = thirdIndex.getSecond_index();
        FirstIndex firstIndex = thirdIndex.getFirst_index();

        //将一二三级指标装配进FourthIndex中
        fourthIndex.setFirstIndex(firstIndex);
        fourthIndex.setSecondIndex(secondIndex);
        fourthIndex.setThirdIndex(thirdIndex);
        //传过来的fourthIndex应该有所属三级指标的值
        fourthIndexService.addFourthIndex(fourthIndex);

        return "redirect:/index/list/"+parentIndexId;
    }

    /**
     * 删除
     * @param fourthIndexId
     * @return
     */
    @RequestMapping("/fourthIndex/delete/{fourthIndexId}")
    public String weightDelete(@PathVariable("fourthIndexId") Integer fourthIndexId){
        //System.out.println(fourthIndexId);

        FourthIndex newFourthIndex = fourthIndexService.findFourthIndexById(fourthIndexId);
        fourthIndexService.deleteFourthIndexById(fourthIndexId);
        return "redirect:/index/list/" + newFourthIndex.getThirdIndex().getId();
    }
}
