package oop.service;

import oop.models.Director;
import oop.models.Manager;
import oop.models.Programmer;
import oop.models.Worker;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class EmployeeService {
    public static ArrayList<Worker>  readFromFile(String filePath) throws IOException {
        Integer personalCode = null;
        String firstLastName = null;
        Integer positionCode = null;
        String atribute = null;
        Double salary = null;
        String line;

        ArrayList<Worker> workersList = new ArrayList<Worker>();

        //***************Read from file***************
        BufferedReader bufReader = new BufferedReader(new FileReader(filePath));
        while ((line = bufReader.readLine()) != null) {
            String[] parts = line.split("[|]");
            if (parts.length >= 0) {
                personalCode = Integer.valueOf(parts[0].trim());
                firstLastName = parts[1].trim();
                positionCode = Integer.valueOf(parts[2].trim());
                atribute = parts[3].trim();
                salary = Double.valueOf(parts[4].trim());
                workersList.add(new Worker(personalCode, firstLastName, positionCode, salary));
            }
            if (positionCode == 1) {
                Director directorList = new Director(personalCode, firstLastName, positionCode, salary, atribute);
                System.out.println("Director\n" + directorList.toString());
            } else if (positionCode == 2) {
                Manager managerList = new Manager(personalCode, firstLastName, positionCode, salary, Integer.valueOf(atribute));
                System.out.println("\nManager\n" + managerList.toString());
            } else if (positionCode == 3) {
                Programmer programmerList = new Programmer(personalCode, firstLastName, positionCode, salary, atribute);
                System.out.println("\nProgrammer\n" + programmerList.toString());
            }
        } return workersList;
    }
    public static double calculateTotalSalary(ArrayList<Worker> workers){
        double monthlySalary = 0.00;
        for (Worker worker : workers){
            monthlySalary += worker.getSalary();
        }
        return monthlySalary;
    }
    public static void calculatePercentage(ArrayList<Worker> workers, double monthlySalary){
        DecimalFormat df = new DecimalFormat("### . 00");
        for (Worker worker : workers){
            System.out.println(worker.getFirstLastName() + ", " + df.format(worker.getSalary() / monthlySalary * 100));
        }
    }
    public static ArrayList<Worker> updateSalary(ArrayList<Worker> workers){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Enter personal code: ");
        int idnp = scanner.nextInt();
        ArrayList<Worker> updatedWorkerList = new ArrayList<Worker>();
        for (Worker worker : workers) {
            if (worker.getPersonalCode().equals(idnp)) {
                System.out.println("Enter new salary: ");
                worker.setSalary(scanner.nextDouble());
                updatedWorkerList.add(worker);
            }
        }
        return updatedWorkerList;
    }
    public static void getDetailFromEmployees (ArrayList<Worker> workers){
        String firstName;
        int count = 0;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Enter First and Last name: ");
        firstName = scanner1.nextLine();
        for (Worker worker : workers){
            if (worker.getFirstLastName().equalsIgnoreCase(firstName.trim())){
                System.out.println("The list of people with the first and last names entered:");
                System.out.println(worker.toString());
                count++;
            }
        }
        if (count == 0){
            System.out.println("There is no person with such first and last name");
        }
    }
    public static void main(String[] args) throws IOException {
        ArrayList<Worker> worker = readFromFile("employee.txt");
        //*******************Sort***********************
        Collections.sort(worker, Comparator.comparing(Worker::getFirstLastName));

        System.out.println("\n********* Order the list in alphabetical order by FirstLastName ********");
        worker.forEach(System.out::println);

        System.out.println("\n********* Determine the total sum of money necessary for company in order to pay one month salary for all employees ********");
        System.out.println("The total salary is: " + calculateTotalSalary(worker));

        System.out.println("\n********* Each employee's percentage of the total amount is: ********");
        calculatePercentage(worker, calculateTotalSalary(worker));

        System.out.println("\n********* Change employee’s salary by its PersonalCode ********");
        ArrayList<Worker> updatedWorkerList = updateSalary(worker);
        if (updatedWorkerList.size() > 0){
            System.out.println("Updated information by IDNP:");
            updatedWorkerList.forEach(System.out::println);
        }else {
            System.out.println("There is no person with such IDNP:");
        }
        System.out.println();

        System.out.println("\n********* Enter employees FirstLastName and to see all employee details in the terminal ********");
        getDetailFromEmployees(worker);
    }

}
