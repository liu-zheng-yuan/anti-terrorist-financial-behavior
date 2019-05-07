package edu.nju.antiTerroristFinancialBehavior.model.matrix;

import edu.nju.antiTerroristFinancialBehavior.model.ThirdIndex;

public class ThirdIndexMatrix {
    private Integer id;
    private ThirdIndex third_index;
    private Integer professor;
    private String matrix;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setThird_index(ThirdIndex third_index) {
        this.third_index = third_index;
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

    public ThirdIndex getThird_index() {
        return third_index;
    }

    public Integer getProfessor() {
        return professor;
    }

    public String getMatrix() {
        return matrix;
    }
}
