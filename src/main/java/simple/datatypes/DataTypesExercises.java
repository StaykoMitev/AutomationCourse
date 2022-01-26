package simple.datatypes;

import java.util.Scanner;

import static java.lang.Math.*;

public class DataTypesExercises {

    public static void main(String[] args) {
        //storeNames();
        //calculatePerimeter();
        //calculatePerimeter2();
        //calculateArea();
        //printPineTree();
        //printPineTree1();
        solveQuadraticEquation();
    }

    public static void storeNames(){
        String firstName = "Stayko";
        String middleName = " Dimitrov";
        String lastName = " Mitev";
        System.out.println("My name is : " +firstName+middleName+lastName);
    }

    public static void calculatePerimeter(){
        int a =10;
        int b =7;
        int c =5;
        System.out.println("Perimeter is :" +(a+b+c));
    }

    public static void calculatePerimeter2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numer");
        float a = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter side B");
        float b = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter side C");
        float c = Float.parseFloat(scanner.nextLine());
        System.out.println("Perimeter is :" +(a+b+c));
    }

    public static void calculateArea(){
        double a =20;
        double b =18;
        double c =10.5f;
        double halfPerimeter = (a+b+c)/2;
        System.out.println(halfPerimeter);
        double area = sqrt(halfPerimeter*((halfPerimeter-a)*(halfPerimeter-b)*(halfPerimeter-c)));
        System.out.println(area);
    }

    public static void solveQuadraticEquation(){
        double a = 1, b = -5, c = 6;
        double root1, root2;

        double determinant = b*b-4*a*c;

        if(determinant > 0){
            root1 = (-b + Math.sqrt(determinant)/(2*a));
            root2 = (-b - Math.sqrt(determinant)/(2*a));

            System.out.println("root1= "+root1+"; "+"root2= "+root2);
        }
        else if(determinant ==0){
            root1 = root2 = -b/(2*a);
            System.out.println("root1 = root2 = "+root1);
        }
        else {
            double real = -b/(2*a);
            double imaginary = Math.sqrt(-determinant)/(2*a);
            System.out.println(root1 = real+imaginary);
            System.out.println(root2 = real-imaginary);
        }
    }

    public static void printPineTree1(){
        System.out.println("          *");
        System.out.println("         ***");
        System.out.println("        *****");
        System.out.println("       *******");
        System.out.println("      *********");
        System.out.println("     ***********");
        System.out.println("    *************");
        System.out.println("   ***************");
        System.out.println("  *****************");
        System.out.println(" *******************");
    }

    public static void printPineTree(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 - i; j++)
                System.out.print(" ");
            for (int k = 0; k < (2 * i + 1); k++)
                System.out.print("*");
            System.out.println();
        }
    }
}
