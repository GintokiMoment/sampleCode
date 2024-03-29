package com.example.samplecode.models;

import java.util.Date;

public class Task {
    private long id;
    private String description;
    private Date due;
    private boolean done;

//    Constructors.. two diff ways to create a date


    public Task(long id, String description, Date due, boolean done) {
        this.id = id;
        this.description = description;
        this.due = due;
        this.done = done;
    }

    public Task(String description, Date due, boolean done) {
        this.description = description;
        this.due = due;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString(){
        String dueStr = due != null ? due.toString() : "NULL";
//        if due is not null, send to to String : if not, set to null
        return String.format("ID: %d DESC: %s DUE DATE: %s DONE: %b", id, description, dueStr, done);
    }

}
