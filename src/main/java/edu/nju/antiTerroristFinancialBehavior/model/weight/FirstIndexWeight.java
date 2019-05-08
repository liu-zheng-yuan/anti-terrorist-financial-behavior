package edu.nju.antiTerroristFinancialBehavior.model.weight;

import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;

public class FirstIndexWeight {
    private FirstIndex first_index;
    private Integer id;
    private Integer professor;
    private Double weight;

    public FirstIndex getFirst_index() {
        return first_index;
    }

    public void setFirst_index(FirstIndex first_index) {
        this.first_index = first_index;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
