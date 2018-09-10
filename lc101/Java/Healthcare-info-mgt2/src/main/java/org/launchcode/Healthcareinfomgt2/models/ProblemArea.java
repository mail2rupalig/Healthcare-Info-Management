package org.launchcode.Healthcareinfomgt2.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class ProblemArea {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=2, max=30)
    private String area;

    @OneToMany
    @JoinColumn(name = "problem_area_id")
    private List<Disease> diseases;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
