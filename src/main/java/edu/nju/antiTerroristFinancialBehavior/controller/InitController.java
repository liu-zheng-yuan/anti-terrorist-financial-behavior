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

@RestController
public class InitController {

//    @Autowired
//    private FirstIndexMapper firstIndexMapper;

    @Autowired
    private IndexService indexService;

    @GetMapping(value = "/loadMenu/{parentID}")
    public List<MenuItem> loadMenu(@PathVariable("parentID") Integer id){
        return indexService.findMenusItemsByParentID(id);
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
        FirstIndex firstIndex = firstIndexMapper.selectByPrimaryKey(1);
        System.out.println(firstIndex);
    }*/


}
