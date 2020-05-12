package edu.miu.cs.cs472.falcon.service;

import edu.miu.cs.cs472.falcon.model.Job;
import edu.miu.cs.cs472.falcon.repository.JobRepo;
import edu.miu.cs.cs472.falcon.repository.LocationRepo;

import java.util.List;

public class JobService {
    private static JobRepo jobRepo = new JobRepo();

    public static List<Job> getJobs(String q, String location) {
        return jobRepo.getJobs(q, location);
    }

    public static void addJob(Job job) {
        jobRepo.addJob(job);
    }

    public static Job getJobById(String id) {
        return jobRepo.getJobById(id);
    }

}
