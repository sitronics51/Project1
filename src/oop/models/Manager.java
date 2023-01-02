package oop.models;

public class Manager extends Worker {
    private Integer teamMembers;
    public Manager(Integer personalCode, String firstLastName, Integer positionCode, Double salary, Integer teamMembers) {
        super(personalCode, firstLastName, positionCode, salary);
        this.teamMembers = teamMembers;
    }

    public Integer getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Integer teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Override
    public String toString() {
        return getPersonalCode() + " " + getFirstLastName() + " " + getPositionCode() + " " + teamMembers + " " + getSalary();
    }
}
