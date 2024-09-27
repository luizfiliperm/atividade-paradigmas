package sevices;

import domain.candidate.Candidate;
import domain.company.Company;
import domain.job.Job;
import exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

public class JobService {

    public Job registerJob(Company company, Integer jobId, String jobTittle , String jobDescription, List<String> jobSkills) {
        company.addJob(new Job(jobId, jobTittle, jobDescription, jobSkills));

        return company.getJobById(jobId);
    }

    public Job registerCandidate(Candidate candidate, Job job) {
        if (job.getCandidateList().contains(candidate)) {
            throw new BusinessException("The candidate " + candidate.getName() + " is already registered for the job");
        }

        job.addCandidate(candidate);
        return job;
    }

    public List<Candidate> buildQualifiedCandidateList(Job job){
        List<Candidate> qualifiedCandidateList = new ArrayList<>();
        for (Candidate candidate : job.getCandidateList()) {
            if(candidate.hasNecessarySkills(job.getNecessarySkills())){
                qualifiedCandidateList.add(candidate);
            }
        }
        return qualifiedCandidateList;
    }
}
