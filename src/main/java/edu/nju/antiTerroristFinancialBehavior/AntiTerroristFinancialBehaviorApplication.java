package edu.nju.antiTerroristFinancialBehavior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//todo
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AntiTerroristFinancialBehaviorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntiTerroristFinancialBehaviorApplication.class, args);
    }

}
