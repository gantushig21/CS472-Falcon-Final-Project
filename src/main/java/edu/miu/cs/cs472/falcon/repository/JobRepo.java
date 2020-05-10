package edu.miu.cs.cs472.falcon.repository;

import com.opencsv.CSVReader;
import edu.miu.cs.cs472.falcon.model.Job;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobRepo {
    private static List<Job> jobs = new ArrayList<>();

    public static List<Job> getJobs() {
        if (jobs.size() > 0)
            return jobs;

        try {
            FileReader fileReader = new FileReader("src/main/resources/dice_com-job_us_sample.csv");
            CSVReader csvReader = new CSVReader(fileReader);

            String[] record;
            int i = 0;
            while ((record = csvReader.readNext()) != null && i++ < 10) {
                jobs.add(new Job(record[0], record[1], record[2], new Date(), record[4], record[5], record[6], record[7]));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return jobs;
    }
}
