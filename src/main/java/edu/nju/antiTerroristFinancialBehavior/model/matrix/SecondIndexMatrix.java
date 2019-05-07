package edu.nju.antiTerroristFinancialBehavior.model.matrix;

import edu.nju.antiTerroristFinancialBehavior.model.SecondIndex;

public class SecondIndexMatrix {
    private Integer id;
    private SecondIndex second_index;
    private Integer professor;
    private String matrix;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSecond_index(SecondIndex second_index) {
        this.second_index = second_index;
    }

    public void setProfessor(Integer professor) {
        this.professor = professor;
    }

    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }

    public Integer getId() {
        return id;
    }

    public SecondIndex getSecond_index() {
        return second_index;
    }

    public Integer getProfessor() {
        return professor;
    }

    public String getMatrix() {
        return matrix;
    }
}
