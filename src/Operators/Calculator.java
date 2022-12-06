package Operators;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        //Declaration of variables
        char operator;
        double number1;
        double number2;
        double result;

        //Create an object of Scanner class
        Scanner scanner = new Scanner(System.in);

        // enter operator
        System.out.println("Chose an operator: +, -, *, /, ^");
        operator = scanner.next().charAt(0);

        //Add first number
        System.out.println("Enter first number: ");
        number1 = scanner.nextInt();

        //Add second number
        System.out.println("Enter second number");
        number2 = scanner.nextInt();

        switch (operator){
            // add the numbers
            case '+':
                result = number1 + number2;
                System.out.println(number1 + " + " + number2 + " = " + result);
                break;

            //performs subtraction between numbers
            case '-':
                result = number1 - number2;
                System.out.println(number1 + " - " + number2 + " = " + result);
                break;

            //performs multiplication between numbers
            case '*':
                result = number1 * number2;
                System.out.println(number1 + " * " + number2 + " = " + result);
                break;

            //performs division between numbers
            case '/':
                result = number1 / number2;
                System.out.println(number1 + " / " + number2 + " = " + result);
                break;

            //performs power between numbers
            case '^':
                result = Math.pow(number1 , number2);
                System.out.println(number1 + " ^ " + number2 + " = " + result);
                break;

            default:
                System.out.println("Invalid Operator!");
                break;
        }
    }
}
