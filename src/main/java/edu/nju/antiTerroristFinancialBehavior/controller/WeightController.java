package edu.nju.antiTerroristFinancialBehavior.controller;

import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;
import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;
import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;
import edu.nju.antiTerroristFinancialBehavior.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权重值·
 *
 * @author fanleehao on 2019/4/10
 */

@Controller
public class WeightController {

    @Autowired
    private IndexService indexService;

    /**
     * 列举四级指标
     * 后续修改：根据不同等级指标的参数，
     * 使用模型返回不同的指标子集
     */
    @RequestMapping("/weightList")
    public String weightList(){
        return "weightList";
    }

    /**
     * 根据三级指标，列举四级指标
     * @param thirdIndexId
     * @return
     */
    @GetMapping("/weightList/{thirdIndexId}")
    public String loadThirdIndex(@PathVariable("thirdIndexId") Integer thirdIndexId, Model model){
//        List<ThirdIndex> thirdIndices = indexService.findThirdIndicesBySecondIndexId(thirdIndexId);
/*        for (ThirdIndex thirdIndex : thirdIndices) {
            System.out.println(thirdIndex);
        }*/

        List<FourthIndex> fourthIndices = indexService.findFourthIndicesByThirdIndexId(thirdIndexId);
       /* for (FourthIndex fourthIndex: fourthIndices) {
            System.out.println(fourthIndex);
        }*/

        model.addAttribute("fourthIndices", fourthIndices);
        return "weightList";
    }



    /**
     * 编辑指标
     */
    @RequestMapping("/weightEdit/{fourthIndexId}")
    public String weightEdit(Model model, @PathVariable("fourthIndexId") Integer id){
        FourthIndex fourthIndex = indexService.findFourthIndexById(id);
        model.addAttribute("fourthIndex", fourthIndex);
        return "weightEdit";
    }

    /**
     * 更新指标
     * @param fourthIndex
     * @return
     */
    @PostMapping("/weightUpdate")
    public String weightUpdate(FourthIndex fourthIndex){
//        System.out.println(fourthIndex);

        FourthIndex newFourthIndex = indexService.updateFourthIndex(fourthIndex);
        //返回主页
        return "redirect:/weightList/" + newFourthIndex.getThirdIndex().getId();
    }

    /**
     * 转向新增指标页面
     * @param parentIndexId
     * @return
     */
    @GetMapping("/weightAdd")
    public String weightAdd(@RequestParam("parentIndexId") String parentIndexId,Model model) {
        model.addAttribute("parentIndexId", parentIndexId);
        //判断新增指标的父指标是第几级:一级、二级、三级
        int level = indexService.getParentIndexIdLevel(parentIndexId);
        if (level == 1) {
            return "weightAdd2";
        } else if (level == 2) {
            return "weightAdd3";
        } else{
            return "weightAdd4";
        }

    }
    /**
     * 增加指标（可以增加二级、三级、四级指标）
     * @param secondIndex
     * @return
     */
    @PostMapping("/weightAdd2")
    public String weightAdd2(SecondIndex secondIndex) {

        return "weightList";
    }
    /**
     * 增加指标（可以增加二级、三级、四级指标）
     * @param thirdIndex
     * @return
     */
    @PostMapping("/weightAdd3")
    public String weightAdd3(ThirdIndex thirdIndex) {
        return "weightList";
    }
    /**
     * 增加指标（可以增加二级、三级、四级指标）
     * @param fourthIndex,parentIndexId
     * @return
     */
    @PostMapping("/weightAdd4")
    public String weightAdd4(FourthIndex fourthIndex,@RequestParam("parentIndexId")String parentIndexId) {
        //找到四级指标所属三级指标的id
        ThirdIndex thirdIndex = new ThirdIndex();
        thirdIndex.setId(Integer.valueOf(parentIndexId));
        //找到三级指标所属二级指标的id
        int secondIndexId = indexService.getThirdIndexParentId(Integer.valueOf(parentIndexId));
        SecondIndex secondIndex = new SecondIndex();
        secondIndex.setId(secondIndexId);
        //找到二级指标所属一级指标的id
        int firstIndexId = indexService.getSecondIndexParentId(secondIndexId);
        FirstIndex firstIndex = new FirstIndex();
        firstIndex.setId(firstIndexId);
        //将一二三级指标装配进FourthIndex中
        fourthIndex.setFirstIndex(firstIndex);
        fourthIndex.setSecondIndex(secondIndex);
        fourthIndex.setThirdIndex(thirdIndex);
        //传过来的fourthIndex应该有所属三级指标的值
        indexService.addFourthIndex(fourthIndex);
        return "redirect:weightList/"+parentIndexId;
    }
//    /**
//     * 新增四级指标
//     * @param fourthIndex
//     * @return
//     */
//    @PostMapping("/addFourthIndex")
//    public String addFourthIndex(FourthIndex fourthIndex){
//        FourthIndex newFourthIndex = indexService.addFourthIndex(fourthIndex);
//        return "redirect:weightList/" + newFourthIndex.getThirdIndex().getId();
//    }

    /**
     * 删除
     * @param fourthIndexId
     * @return
     */
    @RequestMapping("/weightDelete/{fourthIndexId}")
    public String weightDelete(@PathVariable("fourthIndexId") Integer fourthIndexId){
        //System.out.println(fourthIndexId);

        FourthIndex newFourthIndex = indexService.findFourthIndexById(fourthIndexId);
        indexService.deleteFourthIndexById(fourthIndexId);
        return "redirect:/weightList/" + newFourthIndex.getThirdIndex().getId();
    }




    /**
     * 指标定权---矩阵
     */
    @RequestMapping("/weightMatrix")
    public String weightMatrix(){
        return "weightMatrix";
    }


    @RequestMapping("/modelDisplay")
    public String modelDisplay() {return "modelDisplay";}

    @RequestMapping("/resultCalculate")
    public String resultCalculate() {return "resultCalculate";}

    @RequestMapping("/Marking")
    public String Marking() {return "Marking";}

    @RequestMapping("/index")
    public String index() {return "index"; }

    @RequestMapping("/Score")
    public String Score() {return "Score";}

    @RequestMapping("/result")
    public String result() {return "result";}

    @RequestMapping("/model")
    public String model() {return "model";}
}