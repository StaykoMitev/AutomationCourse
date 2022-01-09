package simple.conditionandloops;

import java.util.Scanner;

public class Exercises {
    public static void main(String args[]) {
        inputAge();
    }

    //Exercises 1
    //1. Write a program to print the days of the week based on the user digit 1-7 input. The message should be “The [user input digit]-
    //st/nd/rd/th day of the week is [the day of the week]” Hint: Use switch-case
    public static void daysOfTheWeek() {
        int i = 0;

        for (i = 1; i <= 7; i++) {
            switch (i) {
                case 1: {
                    System.out.println(i + "st day of the week is Monday");
                    break;
                }
                case 2: {
                    System.out.println(i + "nd day of the week is Tuesday");
                    break;
                }
                case 3: {
                    System.out.println(i + "rd day of the week is Wednesday");
                    break;
                }
                case 4: {
                    System.out.println(i + "th day of the week is Thursday");
                    break;
                }
                case 5: {
                    System.out.println(i + "th day of the week is Friday");
                    break;
                }
                case 6: {
                    System.out.println(i + "th day of the week is Saturday");
                    break;
                }
                case 7: {
                    System.out.println(i + "th day of the week is Sunday");
                    break;
                }
                default:
                    System.out.println("Default");
            }
        }
    }

    //Exercises 2
    //Write Java program to allow the user to input his/her age. Then the program will show if the person is eligible to work. A person
    //who is eligible to work must be older than or equal to 16 years old.
    public static void inputAge() {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter person's age: ");
        int age = in.nextInt();

        if (age >= 16) System.out.println("Person is eligible to work.");
        else System.out.println("Person is NOT eligible to work.");
    }
}
