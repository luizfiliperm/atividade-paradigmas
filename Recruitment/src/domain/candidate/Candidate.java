package domain.candidate;

import interfaces.Person;

import java.util.List;
import java.util.Objects;

public class Candidate implements Person {

    private Integer id;

    private String name;

    private String email;

    private List<String> skillList;

    public Candidate() {
    }

    public Candidate(Integer id, String name, String email, List<String> skillList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.skillList = skillList;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    public Integer getId(){
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<String> skillList) {
        this.skillList = skillList;
    }

    public boolean hasNecessarySkills(List<String> necessarySkillList) {
        if (necessarySkillList == null || necessarySkillList.isEmpty()) {
            return true;
        }
        return skillList != null && skillList.containsAll(necessarySkillList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(id, candidate.id) && Objects.equals(name, candidate.name) && Objects.equals(email, candidate.email) && Objects.equals(skillList, candidate.skillList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, skillList);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + this.getName() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                '}';
    }
}
