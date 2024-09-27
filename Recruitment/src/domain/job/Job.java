package domain.job;

import domain.candidate.Candidate;

import java.util.ArrayList;
import java.util.List;

public class Job {

    private Integer id;

    String tittle;

    private String description;

    List<Candidate> candidateList;

    List<String> necessarySkills;

    public Job(){

    }

    public Job(Integer id, String tittle, String description, List<String> necessarySkills) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.necessarySkills = necessarySkills;
        this.candidateList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public void addCandidate(Candidate candidate) {
        this.candidateList.add(candidate);
    }

    public List<String> getNecessarySkills() {
        return necessarySkills;
    }

    public void addSkill(String skill) {
        this.necessarySkills.add(skill);
    }
}
