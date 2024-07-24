package com.amponsem.librarymanagementsystem.models;

import java.sql.Date;

public class Member {
    private int id;
    private String firstName;
    private String lastName;
    private Date joinedDate;
    private int activeStatusId;

    public Member(int id, String firstName, String lastName, Date joinedDate, int activeStatusId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinedDate = joinedDate;
        this.activeStatusId = activeStatusId;
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

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public int getActiveStatusId() {
        return activeStatusId;
    }

    public void setActiveStatusId(int activeStatusId) {
        this.activeStatusId = activeStatusId;
    }
}
