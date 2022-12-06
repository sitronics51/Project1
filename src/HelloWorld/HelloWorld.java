package HelloWorld;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        /*String name = "Jony!";
        System.out.println("Hello, " + name);// Metoda de citire dintr-o variabilДѓ
        */
        Scanner scanner1 = new Scanner(System.in);
        String name;

        System.out.println("Enter your first and last name:");
        name = scanner1.nextLine();
        System.out.print("Hello, " + name);
    }
}

