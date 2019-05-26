package edu.nju.antiTerroristFinancialBehavior;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"edu.nju.antiTerroristFinancialBehavior.mapper","edu.nju.antiTerroristFinancialBehavior.mapper.*"})  //mapper接口
public class AntiTerroristFinancialBehaviorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntiTerroristFinancialBehaviorApplication.class, args);
    }

}
