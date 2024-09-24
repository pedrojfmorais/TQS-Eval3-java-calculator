package calculator;

import java.util.Scanner;

public class Calculator {

    public static boolean parseExpression(String input) {
        //Trim the String from trailing whitespaces for comparisons
        input = input.trim();
        //Check if the entered string was quit regardless of the case to end the program
        if (input.equalsIgnoreCase("quit")) {
            return false;
        } else {
            try {
                //Split the String to a String array using whitespace separation
                String[] expression = input.split(" ");
                //If the String is not quit and its containing one word then it is an invalid math function
                if (expression.length < 2) {
                    System.out.println("Invalid Input");
                } else if (expression.length == 2) { // If its containing exactly two words then its a trigonometric function
                    //The first word is the trig function
                    String trigFunction = expression[0].toLowerCase();
                    //The second word is the angle
                    double angle = Double.parseDouble(expression[1]);
                    switch (trigFunction) {
                    case "cos":
                        //Printf for displaying the double with two decimal places not 1 as in example
                        System.out.printf("%.2f\n", Math.cos(Math.toRadians(angle)));
                        break;
                    case "sin":
                        System.out.printf("%.2f\n", Math.sin(Math.toRadians(angle)));
                        break;
                    case "tan":
                        System.out.printf("%.2f\n", Math.tan(Math.toRadians(angle)));
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                    }
                } else if (expression.length == 3) { //If its containing 3 words then its an arithmetic function
                    //Operand 1
                    double op1 = Double.parseDouble(expression[0]);
                    //Arithmetic operation
                    char operation = expression[1].charAt(0);
                    //Operand 2
                    double op2 = Double.parseDouble(expression[2]);
                    switch (operation) {
                    case '+':
                        System.out.printf("%.2f\n", op1 + op2);
                        break;
                    case '-':
                        System.out.printf("%.2f\n", op1 - op2);
                        break;
                    case '*':
                        System.out.printf("%.2f\n", op1 * op2);
                        break;
                    case '/':
                        System.out.printf("%.2f\n", op1 / op2);
                        break;
                    case '^':
                        System.out.printf("%.2f\n", Math.pow(op1, op2));
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
            return true;
        }
    }

    public static void readUserInput() {
        //Get user input using Scanner class
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        //Continously prompt for input
        while (loop) {
            System.out.print(">");
            //Read the line that the user will type
            String input = sc.nextLine();
            //Parse the expression and determine wether to continue prompting or not
            loop = parseExpression(input);
        }
        //Free all resources used by Scanner class
        sc.close();
        System.out.println("GoodBye!");
    }

    public static void main(String[] args) {
        readUserInput();
    }
}
