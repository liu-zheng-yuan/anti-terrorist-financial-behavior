package edu.nju.antiTerroristFinancialBehavior.utils;


import edu.nju.antiTerroristFinancialBehavior.service.CommonIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ShowPersonInfo {
    CommonIndexService commonIndexService;

    public ShowPersonInfo(CommonIndexService commonIndexService) {
        this.commonIndexService = commonIndexService;
    }

    public Map<String, Double> computeScore(String infile, String id){
        Map<String, Double> map = new HashMap<>();
        String line = "";
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(infile));
            while((line = bufferedReader.readLine()) != null){
                String[] strings = line.split(",");
                if(strings[0].equals("benfangzhanghao")){
                    for(int i = 1; i < strings.length; i++){
                        ids.add(Integer.valueOf(strings[i]));
                    }
                }
                if(strings[0].equals(id)){
                    for(int i = 1; i < strings.length; i++){
                        values.add(Double.valueOf(strings[i]));
                    }
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
        names = commonIndexService.findFouthIndecesNamesById(ids);
        for(int i = 0; i < names.size(); i++){
            map.put(names.get(i), values.get(i));
        }
        return map;
    }

}

