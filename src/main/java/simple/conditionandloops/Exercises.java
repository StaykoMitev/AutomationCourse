package simple.conditionandloops;

import java.util.Scanner;

public class Exercises {
    public static void main(String args[]) {
        discount();
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

    //Exercises 3
    //Write a Java program to calculate the revenue from a sale based on the unit price and quantity of a product input by the user.
    //The discount rate is 15% for the quantity purchased between 100 and 120 units, and 20% for the quantity purchased greater than
    //120 units. If the quantity purchased is less than 100 units, the discount rate is 0%.
    public static void discount() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter unit price: ");
        int price = in.nextInt();

        System.out.print("Enter quantity: ");
        int quantity = in.nextInt();

        int discount = 0;

        if (quantity >= 100 && quantity<=120) discount = 15;
        else if (quantity > 120) discount = 20;

        System.out.println("The revenue from sale: " + ((quantity*price)-(quantity*price*discount/100)) + "$");
        System.out.println("After discount: " + (quantity*price*discount/100) + "$ (" + discount + "%)");
    }

    //Exercises 4
    //Find the largest number from a given array and print it in a console. Hint: use for loop
    public static void largestNum() {

    }

    //Exercises 5
    //Write a program which advices the user where to go to a vacation based on the type of the vacation and the budget. There
    //should be two options – Beach, Mountain. If the user put a different value then the program should print a message that there is
    //no information about this type of vacation. Budgets are considered per day per person. If the budget per day for Beach type
    //vacation is smaller than 50 then the program should advise Bulgaria as a destination, otherwise Outside Bulgaria. If the budget
    //per day for Mountain type vacation is smaller than 30 then the program should advise Bulgaria as a destination, otherwise
    //Outside Bulgaria.
    public static void vacation() {

    }

    //Exercises 6
    //Given a list iterate it and display numbers which are divisible by 5 and if you find number greater than 150 stop the loop
    //iteration list1 = [12, 15, 32, 42, 55, 75, 122, 132, 150, 180, 200]
    public static void divisible() {

    }

    //Exercises 7
    //Reverse the following list using for loop list1 = [10, 20, 30, 40, 50]
    public static void reverse() {

    }
}
