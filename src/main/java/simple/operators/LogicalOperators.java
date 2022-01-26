package simple.operators;

public class LogicalOperators {
    static boolean a = true;
    static boolean b= false;
    static int intA = 5;
    static int intB = 11;


    public static void main(String[] args) {
        logicalAnd2();
        logicalOr();
        reversOperator();
    }

    public static void logicalAnd(){
        System.out.println(a&&b);
    }
    //Check if number is between defined range
    public static void logicalAnd2(){
        System.out.println((intA>=1&&intA<=10));
        System.out.println(intB>=1&&intB<=10);
    }

    public static void logicalOr(){
        System.out.println(a||b);
    }

    public static void reversOperator(){
        System.out.println(!(a&&b));
    }
}
