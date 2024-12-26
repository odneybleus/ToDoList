package com.revature.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int taskID;
    private String taskTitle;
    private boolean isCompleated;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    public Task() {
    }

    public Task(boolean isCompleated, User user, String taskTitle, int taskID) {
        this.isCompleated = isCompleated;
        this.user = user;
        this.taskTitle = taskTitle;
        this.taskID = taskID;
    }

    public boolean isCompleated() {
        return isCompleated;
    }

    public void setCompleated(boolean compleated) {
        isCompleated = compleated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
}
