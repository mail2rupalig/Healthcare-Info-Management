package org.launchcode.Healthcareinfomgt2.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class DoctorLanding {


    public void setId(Integer id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setFirst_name(Object first_name) {
        this.first_name = first_name;
    }

    public void setProblemArea(String problemArea) {
        this.problemArea = problemArea;
    }

    private Integer id;
    private Integer age;
    private Object first_name;
    private String problemArea;

    public DoctorLanding () { }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public Object getFirst_name() {
        return first_name;
    }

    public String getProblemArea() {
        return problemArea;
    }

    public DoctorLanding(Integer id, String firstName, Integer age, String problemArea) {
        this.first_name = firstName;
        this.id = id;
        this.age = age;
        this.problemArea = problemArea;
    }
}