package com.revature.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int userID;

    @Column(name= "username")
    private String userName;
    private String userPassword;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();

    public User() {
    }

    public User(String email, List<Task> tasks, int userID, String userName, String userPassword) {
        this.email = email;
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(String email, List<Task> tasks, String userPassword, String userName) {
        this.email = email;
        this.userPassword = userPassword;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
