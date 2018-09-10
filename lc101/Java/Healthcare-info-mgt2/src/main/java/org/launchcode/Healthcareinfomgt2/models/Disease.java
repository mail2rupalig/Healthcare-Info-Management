package org.launchcode.Healthcareinfomgt2.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Disease {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @ManyToOne
    private ProblemArea problemArea;


    @ManyToOne
    private User patient;

    @OneToMany
    @JoinColumn(name = "disease_id")
    private List<Symptons> symptons;

    @OneToMany
    @JoinColumn(name = "disease_id")
    private List<Treatment> treatments;

    @OneToMany
    @JoinColumn(name = "disease_id")
    private List<Medication> medications;

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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public ProblemArea getProblemArea() {
        return problemArea;
    }

    public void setProblemArea(ProblemArea problemArea) {
        this.problemArea = problemArea;
    }

}
