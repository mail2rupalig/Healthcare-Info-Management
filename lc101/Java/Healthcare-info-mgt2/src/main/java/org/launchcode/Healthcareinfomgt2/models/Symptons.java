package org.launchcode.Healthcareinfomgt2.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Symptons {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String description;

    @NotNull
    private Date date_observed;

    @ManyToOne
    private Disease disease;

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_observed() {
        return date_observed;
    }

    public void setDate_observed(Date date_observed) {
        this.date_observed = date_observed;
    }
}
