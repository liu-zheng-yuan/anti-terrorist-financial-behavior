package edu.nju.antiTerroristFinancialBehavior.model.weight;

import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;

public class ThirdIndexWeight {
    private Integer id;
    private ThirdIndex third_index;
    private Integer professor;
    private Double weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ThirdIndex getThird_index() {
        return third_index;
    }

    public void setThird_index(ThirdIndex third_index) {
        this.third_index = third_index;
    }

    public Integer getProfessor() {
        return professor;
    }

    public void setProfessor(Integer professor) {
        this.professor = professor;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
