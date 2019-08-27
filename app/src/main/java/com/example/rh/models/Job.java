package com.example.rh.models;

import java.util.ArrayList;

public class Job {
    String label;
    String Locate;
    String company;

    public Job(String label, String locate, String company) {
        this.label = label;
        Locate = locate;
        this.company = company;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLocate() {
        return Locate;
    }

    public void setLocate(String locate) {
        Locate = locate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public static ArrayList<Job> createContactsList(int numContacts) {
        ArrayList<Job> jobs = new ArrayList<Job>();

        for (int i = 1; i <= numContacts; i++) {
            jobs.add(new Job("Dev Android","87654","TEST"));
        }

        return jobs;
    }
}
