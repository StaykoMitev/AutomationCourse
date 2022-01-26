package simple.operators;

import java.util.Scanner;

public class OperatorsExercise {

    public static void main(String[] args) {

        //add input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter angle A");
        float a = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter angle B");
        float b = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter angle C");
        float c = Float.parseFloat(scanner.nextLine());

        //Is triangle possible to build and
        // if true check its type
        if(a+b+c==180){
            System.out.println("Triangle can be build and is: ");
            if(a==90 || b==90 || c==90){
                System.out.println("Right-angled");
            }
            if(a==60 && b==60 && c==60){
                System.out.println("Equilateral ");
            }
            if(a==b || b==c || c==a){
                System.out.println("Isosceles");
            }
            if(a<90 && b<90 && c<90){
                System.out.println("Triangle is Acute");
            }
            if(a>90 || b>90 || c>90){
                System.out.println("Acute");
            }
        } else{
            System.out.println("Triangle cannot be build");
        }
    }

    //is number even
    public static void checkIfNumberIsEven() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        float a = Float.parseFloat(scanner.nextLine());
        System.out.println((a % 2) == 0);
    }
}
