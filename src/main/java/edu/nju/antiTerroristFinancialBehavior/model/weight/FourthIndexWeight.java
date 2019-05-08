package edu.nju.antiTerroristFinancialBehavior.model.weight;

import edu.nju.antiTerroristFinancialBehavior.model.FourthIndex;

public class FourthIndexWeight {
    private Integer id;
    private FourthIndex fourth_index;
    private Integer professor;
    private Double weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FourthIndex getFourth_index() {
        return fourth_index;
    }

    public void setFourth_index(FourthIndex fourth_index) {
        this.fourth_index = fourth_index;
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
