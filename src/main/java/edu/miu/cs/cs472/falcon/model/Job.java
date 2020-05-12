package edu.miu.cs.cs472.falcon.model;

import edu.miu.cs.cs472.falcon.utils.FactoryMethod;

import java.util.Date;

public class Job {
    private String id;
    private String company = null;
    private String status = null;
    private String description = null;
    private String location = null;
    private String title = null;
    private Date postDate = null;
    private String shift = null;
    private String skills = null;
    private Contact contact = null;

    public Job(String company, String status, String description, String location, String title, Date postDate, String shift, String skills, Contact contact) {
        this.id = FactoryMethod.getUniqueId();
        this.company = company;
        this.status = status;
        this.description = description;
        this.location = location;
        this.title = title;
        this.postDate = postDate;
        this.shift = shift;
        this.skills = skills;
        this.contact = contact;
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

    public String getId() {
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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", title='" + title + '\'' +
                ", postDate=" + postDate +
                ", shift='" + shift + '\'' +
                ", skills='" + skills + '\'' +
                ", contact=" + contact +
                '}';
    }
}
