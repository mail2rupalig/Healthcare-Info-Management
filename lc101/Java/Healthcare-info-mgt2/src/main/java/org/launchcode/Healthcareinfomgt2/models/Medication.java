package org.launchcode.Healthcareinfomgt2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Medication {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String description;

    @NotNull
    private Date date_started;

    @ManyToOne
    private Disease disease;

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

    public Date getDate_started() {
        return date_started;
    }

    public void setDate_started(Date date_started) {
        this.date_started = date_started;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}
