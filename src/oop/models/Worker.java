package oop.models;

public class Worker {
    private Integer personalCode;
    private String firstLastName;
    private Integer positionCode;
    private Double salary;

    public Worker(Integer personalCode, String firstLastName, Integer positionCode, Double salary) {
        this.personalCode = personalCode;
        this.firstLastName = firstLastName;
        this.positionCode = positionCode;
        this.salary = salary;
    }

    public Integer getPersonalCode() {
        return personalCode;
    }
    public void setPersonalCode(Integer personalCode) {
        this.personalCode = personalCode;
    }
    public String getFirstLastName() {
        return firstLastName;
    }
    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }
    public Integer getPositionCode() {
        return positionCode;
    }
    public void setPositionCode(Integer positionCode) {
        this.positionCode = positionCode;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return getPersonalCode() + " " + getFirstLastName() + " " + getPositionCode() + " " + getSalary();
    }

}
