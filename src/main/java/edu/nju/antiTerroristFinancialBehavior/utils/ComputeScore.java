package edu.nju.antiTerroristFinancialBehavior.utils;

import edu.nju.antiTerroristFinancialBehavior.service.CommonIndexService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ComputeScore {

    @Autowired
    CommonIndexService commonIndexService;

    public Map<String, Double> computeScore(String infile){
        String line = "";
        Map<String, Double> map = new HashMap<>();
        ArrayList<Integer> ids = new ArrayList<>();
        List<Double> weights = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(infile));
            while((line = bufferedReader.readLine()) != null){
                String[] strings = line.split(",");
                if(strings[0].equals("benfangzhanghao")){
                    for(int i = 1; i < strings.length; i++){
                        ids.add(Integer.valueOf(strings[i]));
                    }
                    weights = commonIndexService.findResultWeights(ids);
                    continue;
                }else{
                    double sum = 0.0;
                    for(int i = 1; i < strings.length; i++){
                        sum += Double.valueOf(strings[i]) * weights.get(i-1);
                    }
                    map.put(strings[0], sum);
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
        //将最后的结果按照评分降序排列
        Map<String, Double> sortedMap = new LinkedHashMap<>();

        map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

//        System.out.println(sortedMap);
        return sortedMap;
    }

}
