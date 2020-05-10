package edu.miu.cs.cs472.falcon.service;

import edu.miu.cs.cs472.falcon.model.Job;
import edu.miu.cs.cs472.falcon.repository.JobRepo;

import java.util.List;

public class JobService {
    public static List<Job> getJobs() {
        return JobRepo.getJobs();
    }
}
