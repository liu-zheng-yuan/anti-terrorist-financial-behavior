package edu.nju.antiTerroristFinancialBehavior.controller.index;

import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.service.index.FourthIndexService;
import edu.nju.antiTerroristFinancialBehavior.service.CommonIndexService;
import edu.nju.antiTerroristFinancialBehavior.service.index.ThirdIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 公共指标界面控制
 *
 * @author fanleehao on 2019/4/29
 */


@Controller
public class CommonIndexController {

    @Autowired
    private ThirdIndexService thirdIndexService;
    @Autowired
    private FourthIndexService fourthIndexService;

    @Autowired
    private CommonIndexService commonIndexService;


    /**
     * 主界面显示
     * 分别查询出当前所属二级、三级、四级指标的内容，都需要显示
     * @param thirdIndexId
     * @param model
     * @return
     */
    @GetMapping("/index/list/{thirdIndexId}")
    public String loadThirdIndex(@PathVariable("thirdIndexId") Integer thirdIndexId, Model model){

        List<FourthIndex> fourthIndices = fourthIndexService.findFourthIndicesByThirdIndexId(thirdIndexId);

        //V1.0---二级、三级指标的删除，暂且统一读出到本页面，可以直接删除或编辑
        ThirdIndex curThirdIndex = thirdIndexService.findThirdIndexById(thirdIndexId);
        SecondIndex curSecondIndex = curThirdIndex.getSecond_index();


        model.addAttribute("fourthIndices", fourthIndices);
        model.addAttribute("curThirdIndex", curThirdIndex);
        model.addAttribute("curSecondIndex", curSecondIndex);

        //System.out.println("23333");
        return "index/indexList";
    }

    /**
     * 转向新增指标页面
     * @param parentIndexId
     * @return
     */
    @GetMapping("/weightAdd")
    public String weightAdd(@RequestParam("parentIndexId") String parentIndexId, Model model) {
        model.addAttribute("parentIndexId", parentIndexId);
        //判断新增指标的父指标是第几级:一级、二级、三级
        int level = commonIndexService.getParentIndexIdLevel(parentIndexId);
        if (level == 1) {
            return "index/secondIndexAdd";
        } else if (level == 2) {
            return "index/thirdIndexAdd";
        } else{
            return "index/fourthIndexAdd";
        }

    }

}
