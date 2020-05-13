package edu.miu.cs.cs472.falcon.repository;

import com.opencsv.CSVReader;
import edu.miu.cs.cs472.falcon.model.Contact;
import edu.miu.cs.cs472.falcon.model.Job;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class JobRepo {
    private static LinkedList<Job> jobs = new LinkedList<>();
    private static HashMap<String, Job> jobMap = new HashMap<>();

    static {
        readData();
    }

    public JobRepo() {
    }

    public Job getJobById(String id) {
        return jobMap.get(id);
    }

    public List<Job> getJobs(String q, String location) {
        List<Job> list = jobs.stream()
                            .filter(j -> {
                                return (j.getSkills().toLowerCase().indexOf(q) > -1 ||
                                        j.getTitle().toLowerCase().indexOf(q) > -1 ||
                                        j.getCompany().toLowerCase().indexOf(q) > -1) &&
                                        (j.getLocation().toLowerCase().indexOf(location) > -1);
                            })
                            .collect(Collectors.toList());

        return list;
    }

    public static void readData() {
        try {
           // ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
           // File file = new File(classLoader.getResource("dice_com-job_us_sample.csv").getFile());
//            InputStream is = classLoader.getResourceAsStream();
           // FileReader fileReader = new FileReader(file);
//            FileReader fileReader = new FileReader("/Users/gantushig/IdeaProjects/CS472-Falcon-Final-Project/src/main/resources/dice_com-job_us_sample.csv");
           // CSVReader csvReader = new CSVReader(fileReader);

            FileReader fileReader = new FileReader("C:/dice_com-job_us_sample.csv");
            CSVReader csvReader = new CSVReader(fileReader);

            String[] record;
            int i = 0;
            csvReader.readNext();
            Contact contact = new Contact("Will Smith", "(202) 435-6613", "smith@gmail.com");
            while ((record = csvReader.readNext()) != null) {
                Job newJob = new Job(record[1], record[2], record[3], record[5], record[6], new Date(), record[8], record[10], contact);
                addJob(newJob);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }



    public static void addJob(Job job) {
        jobs.addFirst(job);
        jobMap.put(job.getId(), job);
    }
}
