package edu.miu.cs.cs472.falcon.model;

import java.util.Date;

public class Job {
    private static int uniqueId = 0;
    private int id;
    private String company = null;
    private String status = null;
    private String description = null;
    private Date postDate = null;
    private String shift = null;
    private String skills = null;
    private String location = null;
    private String title = null;

    public Job(String company, String status, String description, Date postDate, String shift, String skills, String location, String title) {
        this.id = (++uniqueId);
        this.company = company;
        this.status = status;
        this.description = description;
        this.postDate = postDate;
        this.shift = shift;
        this.skills = skills;
        this.location = location;
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
