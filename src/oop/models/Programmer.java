package oop.models;

public class Programmer extends Worker {
    private String programingLanguage;
    public Programmer(Integer personalCode, String firstLastName, Integer positionCode, Double salary , String programingLanguage) {
        super(personalCode, firstLastName, positionCode, salary);
        this.programingLanguage = programingLanguage;
    }
    public String getProgramingLanguage() {
        return programingLanguage;
    }

    public void setProgramingLanguage(String programingLanguage) {
        this.programingLanguage = programingLanguage;
    }

    @Override
    public String toString() {
        return getPersonalCode() + " " + getFirstLastName() + " " + getPositionCode() + " " + programingLanguage + " " + getSalary();
    }
}
