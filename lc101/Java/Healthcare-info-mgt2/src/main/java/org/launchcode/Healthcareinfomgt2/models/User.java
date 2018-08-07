package org.launchcode.Healthcareinfomgt2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import java.util.List;
import java.util.ArrayList;

@Entity
public class User {


    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=25, message = "First Name must be atleast 3 characters and cannot exceed 15 characters")
    private String firstName;

    @NotNull
    @Size(min=3, max=50, message = "Last Name must be atleast 3 characters and cannot exceed 15 characters")
    private String lastName;

    @NotNull
    @Size(min=3, message = "Email must be at least 3 characters and cannot exceed 15 characters")
    private String email;

    @NotNull
    private Integer age;

    @NotNull
    @Size(min=3, max=25, message = "User Name must be at least 3 characters and cannot exceed 15 characters")
    private String userName;

    @NotNull
    @Size(min=3, max=15, message = "Password must be at least 3 characters and cannot exceed 15 characters")
    private String password;

    @NotNull
    @Size(min=3, max=15, message = "Insurance Id must be at least 3 characters and cannot exceed 15 characters")
    private String insuranceId;

    @ManyToOne
    private UserType userType;



    public User() { }

    public User(String firstName, String lastName, String email, Integer age, String userName, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.userName = userName;
        this.password = password;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}