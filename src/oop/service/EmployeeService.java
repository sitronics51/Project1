package oop.service;


import oop.models.Director;
import oop.models.Manager;
import oop.models.Programmer;
import oop.models.Workers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;


public class EmployeeService {

    public static void main(String[] args) throws IOException {
        ArrayList<Workers> workersList = new ArrayList<Workers>();

        //***************Read from file***************
        BufferedReader bufReader = new BufferedReader(new FileReader("employee.txt"));
        Integer personalCode = null;
        String firstLastName = null;
        Integer positionCode = null;
        String atribute = null;
        Double salary = null;
        String line;
        Double monthlySalary = 0.00;
        String firstName;
        int idnp;

        while ((line = bufReader.readLine()) != null) {
            String[] parts = line.split("[|]");
            if (parts.length >= 0) {
                personalCode = Integer.valueOf(parts[0].trim());
                firstLastName = parts[1].trim();
                positionCode = Integer.valueOf(parts[2].trim());
                atribute = parts[3].trim();
                salary = Double.valueOf(parts[4].trim());

                //*******************Sort***********************
                workersList.add(new Workers(personalCode, firstLastName, positionCode, salary));
                Collections.sort(workersList, Comparator.comparing(Workers::getFirstLastName));


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
        }
        //************Order the list in alphabetical order by FirstLastName***************
        System.out.println("\n");
        workersList.forEach(System.out::println);

        //****Determine the total sum of money necessary for company in order to pay one month salary for all employees************
        for (Workers worker : workersList){
            monthlySalary += worker.getSalary();
        }
        System.out.println("\n");
        System.out.println("The total salary is: " + monthlySalary);

        //************Each employee's percentage of the total amount***************
        System.out.println("\nEach employee's percentage of the total amount is: ");
        DecimalFormat df = new DecimalFormat("### . 00");
        for (Workers worker : workersList){
            System.out.println(worker.getFirstLastName() + ", " + df.format(worker.getSalary() / monthlySalary * 100));
        }

        //************Change employee’s salary by its PersonalCode***************
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("Enter personal code: ");
        idnp = scanner.nextInt();

        int count = 0;

        for (Workers worker : workersList){
            if (worker.getPersonalCode().equals(idnp)){
                System.out.println("Enter new salary: ");
                worker.setSalary(scanner.nextDouble());
                System.out.println(worker.toString());
                count++;
            }
        }
        if (count == 0){
            System.out.println("There is no person with such IDNP: ");
        }

        //************Enter employees FirstLastName and to see all employee details in the terminal***************
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("Enter First and Last name: ");
        firstName = scanner1.nextLine();

        count = 0;

        for (Workers worker : workersList){
            if (worker.getFirstLastName().equalsIgnoreCase(firstName.trim())){
                System.out.println(worker.toString());
                count++;
            }
        }
        if (count == 0){
            System.out.println("There is no person with such first and last name");
        }
    }

}
