package edu.nju.antiTerroristFinancialBehavior.controller.result;

import edu.nju.antiTerroristFinancialBehavior.service.CommonIndexService;
import edu.nju.antiTerroristFinancialBehavior.utils.ComputeScore;
import edu.nju.antiTerroristFinancialBehavior.utils.ShowPersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

/**
 * 评分结果
 *
 * @author fanleehao on 2019/4/29
 */

@Controller
public class ResultController {

    @Autowired
    CommonIndexService commonIndexService;

    @RequestMapping("/resultCalculate")
    public String resultCalculate() {return "result/resultCalculate";}


    @RequestMapping("/result")
    public String result() {return "result/result";}


    @PostMapping(value = "/dataUpload")
    public String dataUpload(@RequestParam("dataFile") MultipartFile dataFile, HttpSession session, Model model) {
        String fileName = dataFile.getOriginalFilename();
        String filePath = "D:\\data\\";
        File dest = new File(filePath + fileName);
        try {
            dataFile.transferTo(dest);
            model.addAttribute("flag", 1);
            if (session.getAttribute("dataFile") == null) {
                session.setAttribute("dataFile", fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("flag", 0);
        }
        return "forward:/result";
    }

    @GetMapping("/calculateFinalResult")
    public String calculateFinalResult(HttpSession session,Model model) {
        String fileName = (String)session.getAttribute("dataFile");
//        ArrayList<String> userList = new ArrayList<>();
//        ArrayList<Double> scoreList = new ArrayList<>();
        if (fileName != null) {
            String filePath = "D:\\data\\";
            ComputeScore computeScore = new ComputeScore(this.commonIndexService);
            LinkedHashMap<String, Double> resultMap = computeScore.computeScore(filePath + fileName);
            Iterator<Map.Entry<String,Double>> iterator = resultMap.entrySet().iterator();
//            while (iterator.hasNext()) {
//                Map.Entry entry = iterator.next();
//                userList.add((String) entry.getKey());
//                scoreList.add((Double) entry.getValue());
//            }
//            model.addAttribute("userList", userList);
//            model.addAttribute("scoreList", scoreList);
            model.addAttribute("isCalculated", 1);
            model.addAttribute("resultMap", resultMap);
            model.addAttribute("fileName", fileName);

        }
        return "forward:/result";
    }

    //点击查看详情返回csv文件中一条记录的指标kv
    @GetMapping("/personalInfo/{personalId}/{fileName}")
    public String personalInfo(@PathVariable("personalId") String personalId, @PathVariable("fileName")String fileName,Model model) {
        ShowPersonInfo showPersonInfo = new ShowPersonInfo(this.commonIndexService);
        String filePath = "D:\\data\\";
        Map<String, Double> res = showPersonInfo.computeScore(filePath+fileName, personalId);
        model.addAttribute("personalInfo", res);
        model.addAttribute("personalId", personalId);
        return "forward:/personalInfo";
    }

    @RequestMapping("/personalInfo")
    public String personalInfo() {
        return "result/personalInfo";
    }

}
