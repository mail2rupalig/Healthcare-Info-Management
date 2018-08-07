package org.launchcode.Healthcareinfomgt2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;
import java.util.ArrayList;

@Entity
public class UserType {

        @Id
        @GeneratedValue
        private int id;

        @NotNull
        @Size(min=3, max=15)
        private String type;

        @OneToMany
        @JoinColumn(name = "user_type_id")
        private List<User> users = new ArrayList<>();


        public UserType() { }

        public UserType(String type){
            this.type = type;
        }


        public int getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public void setType(String name) {
            this.type = type;
        }


}
