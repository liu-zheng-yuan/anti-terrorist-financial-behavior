package edu.nju.antiTerroristFinancialBehavior.controller;

import edu.nju.antiTerroristFinancialBehavior.mapper.FirstIndexMapper;
import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;
import edu.nju.antiTerroristFinancialBehavior.model.MenuItem;
import edu.nju.antiTerroristFinancialBehavior.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 指标数据库初始化
 *
 * @author fanleehao on 2019/4/19
 */

@Controller
public class InitController {


    @Autowired
    private IndexService indexService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    /**
     * 初始化树形菜单
     * @param id
     * @return
     */
    @GetMapping(value = "/loadMenu/{parentID}")
    @ResponseBody
    public List<MenuItem> loadMenu(@PathVariable("parentID") Integer id){
        return indexService.findMenusItemsByParentID(id);
    }

    /**
     * 主页显示--homepage
     * @return
     */
    @RequestMapping("/homePage")
    public String weightList(){
        //System.out.println("Aboutme....");
        return "homePage";
    }




    /*@GetMapping("/initFirstIndex")
    public void initIndex(){
        List<FirstIndex> firstIndices = firstIndexMapper.findAllFirstIndex();
        for (FirstIndex index : firstIndices) {
            System.out.println(index);
        }
    }

    @GetMapping("/findFirstIndexById")
    public void findFirstIndexById(){
        FirstIndex firstIndex = firstIndexMapper.findSecondIndexById(1);
        System.out.println(firstIndex);
    }*/

}
