package edu.nju.antiTerroristFinancialBehavior.controller.mark;

import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.service.CommonIndexService;
import edu.nju.antiTerroristFinancialBehavior.service.index.FourthIndexService;
import edu.nju.antiTerroristFinancialBehavior.service.index.SecondIndexService;
import edu.nju.antiTerroristFinancialBehavior.service.index.ThirdIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 评分
 *
 * @author fanleehao on 2019/4/30
 */

@Controller
public class MarkController {
    @Autowired
    CommonIndexService commonIndexService;
    @Autowired
    SecondIndexService secondIndexService;
    @Autowired
    ThirdIndexService thirdIndexService;
    @Autowired
    FourthIndexService fourthIndexService;

    @RequestMapping("/marking")
    public String marking() {return "mark/marking";}


    @RequestMapping("/everyIndexMark")
    public String everyIndexMark(@RequestParam("indexId")Integer indexId, Model model) {
        Integer level = commonIndexService.getIndexLevel(String.valueOf(indexId));
        if (level == 1) {
            List<SecondIndex> childrenIndices = secondIndexService.findSecondIndicesByFirstIndexId(indexId);
            model.addAttribute("childrenIndices", childrenIndices);
        } else if (level == 2) {
            List<ThirdIndex> childrenIndices = thirdIndexService.findThirdIndicesBySecondIndexId(indexId);
            model.addAttribute("childrenIndices", childrenIndices);
        } else if (level == 3) {
            List<FourthIndex> childrenIndices = fourthIndexService.findFourthIndicesByThirdIndexId(indexId);
            model.addAttribute("childrenIndices", childrenIndices);
        }
        return "mark/everyIndexMark";
    }

}
