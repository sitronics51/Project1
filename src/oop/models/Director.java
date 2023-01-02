package oop.models;

public class Director extends Worker {
    private String companyName;

    public Director(Integer personalCode, String firstLastName, Integer positionCode, Double salary, String companyName) {
        super(personalCode, firstLastName, positionCode, salary);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return getPersonalCode() + " " + getFirstLastName() + " " + getPositionCode() + " " + companyName + " " + getSalary();
    }
}
