package domain.company;

import domain.job.Job;

import java.util.HashMap;
import java.util.Map;

public class Company {

    private Integer id;

    private String name;

    private Map<Integer, Job> jobMap;

    public Company() {
    }

    public Company(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.jobMap = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Job> getJobMap() {
        return jobMap;
    }

    public void addJob(Job job) {
        this.jobMap.put(job.getId(), job);
    }

    public Job getJobById(Integer jobId) {
        return jobMap.get(jobId);
    }
}
