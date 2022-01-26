package simple.operators;

public class ComparisonOperators {

    static int a = 5;
    static int b = 10;

    public static void main(String[] args) {
        equalOperator();
        notEqualOperator();
        moreThan();
        lessThan();
        moreThanOrEqual();
        lessThanOrEqual();
    }

    public static void equalOperator(){
        System.out.println(a==b);
    }

    public static void notEqualOperator(){
        System.out.println(a!=b);
    }

    public static void moreThan(){
        System.out.println(a>b);
    }

    public static void lessThan(){
        System.out.println(a<b);
    }

    public static void moreThanOrEqual(){
        System.out.println(a>=b);
    }

    public static void lessThanOrEqual(){
        System.out.println(a<=b);
    }
}
