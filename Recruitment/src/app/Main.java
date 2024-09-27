package app;

import domain.candidate.Candidate;
import domain.company.Company;
import domain.job.Job;
import exception.BusinessException;
import sevices.JobService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static JobService jobService = new JobService();

    public static void main(String[] args) {

        Company company = new Company(1, "Google");
        System.out.println("Registering company: " + company.getName());

        List<String> necessaryBackEndSkillList = new ArrayList<>(
                Arrays.asList("Java", "Communication", "noSql", "springboot")
        );
        
        List<String> necessaryFrontEndSkillList = new ArrayList<>(
                Arrays.asList("React", "Communication", "js", "html", "css")
        );


        Job backEndDeveloper = jobService.registerJob(company, 1, "Backend developer", "GoodProgrammer" ,necessaryBackEndSkillList);
        System.out.println("Registering job: " + backEndDeveloper.getTittle());
        Job frontEndDeveloper = jobService.registerJob(company, 2, "FrontendDeveloper", "Good Programmer" ,necessaryFrontEndSkillList);
        System.out.println("Registering job: " + frontEndDeveloper.getTittle());

        List<String> carlosSkillList = new ArrayList<>(
                Arrays.asList("Java", "Communication", "noSql", "springboot", "React")
        );

        List<String> pedroSkillList = new ArrayList<>(
                Arrays.asList("React", "Communication", "js", "html", "css")
        );

        List<String> claudioSkillList = new ArrayList<>(
                Arrays.asList("React")
        );

        Candidate carlos = new Candidate(1, "Carlos", "carlos@email.com", carlosSkillList);
        System.out.println("Registering candidate: " + carlos.getName());
        Candidate pedro = new Candidate(2, "Pedro", "pedro@email.com", pedroSkillList);
        System.out.println("Registering candidate " + pedro.getName());
        Candidate claudio = new Candidate(3, "Claudio", "claudio@email.com", claudioSkillList);
        System.out.println("Registering candidate: " + claudio.getName());

        tryRegisterCandidateToTheJob(carlos, backEndDeveloper);
        tryRegisterCandidateToTheJob(pedro, frontEndDeveloper);
        tryRegisterCandidateToTheJob(claudio, frontEndDeveloper);

        tryRegisterCandidateToTheJob(pedro, frontEndDeveloper);
        tryRegisterCandidateToTheJob(claudio, frontEndDeveloper);

        List<Candidate> qualifiedCandidateListForJob1 = jobService.buildQualifiedCandidateList(backEndDeveloper);
        System.out.println("QualifiedCandidates to the " + backEndDeveloper.getTittle() + " job: " + qualifiedCandidateListForJob1);

        List<Candidate> qualifiedCandidateListForJob2 = jobService.buildQualifiedCandidateList(frontEndDeveloper);
        System.out.println("QualifiedCandidates to the " + frontEndDeveloper.getTittle() + " job: " + qualifiedCandidateListForJob2);
    }

    private static void tryRegisterCandidateToTheJob(Candidate candidate, Job job) {
        try {
            Main.jobService.registerCandidate(candidate, job);
            System.out.println("Registering candidate " + candidate.getName() + " to the Job: " + job.getTittle());
        } catch (BusinessException exception) {
            System.out.println(exception.getMessage());
        }
    }
}