package edu.nju.antiTerroristFinancialBehavior.model.weight;

import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;

public class SecondIndexWeight {
    private Integer id;
    private SecondIndex second_index;
    private Integer professor;
    private Double weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SecondIndex getSecond_index() {
        return second_index;
    }

    public void setSecond_index(SecondIndex second_index) {
        this.second_index = second_index;
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
