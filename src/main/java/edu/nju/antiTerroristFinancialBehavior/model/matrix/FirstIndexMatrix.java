package edu.nju.antiTerroristFinancialBehavior.model.matrix;

import edu.nju.antiTerroristFinancialBehavior.model.FirstIndex;

public class FirstIndexMatrix {
    private Integer id;
    private FirstIndex first_index;
    private Integer professor;
    private String matrix;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FirstIndex getFirst_index() {
        return first_index;
    }

    public void setFirst_index(FirstIndex first_index) {
        this.first_index = first_index;
    }

    public Integer getProfessor() {
        return professor;
    }

    public void setProfessor(Integer professor) {
        this.professor = professor;
    }

    public String getMatrix() {
        return matrix;
    }

    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }
}
