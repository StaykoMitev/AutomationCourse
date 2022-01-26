package simple.datatypes;

public class DataTypes2 {

    static int x = 10;
    static int y = 5;

    public static void main(String[] args) {
        //addition();
        //subtraction();
        //multiply();
        //division();
        //division1();
        //division2();
        //mdulusDivision();
        increment();
        decrement();
    }

    public static void addition(){
        System.out.println(x+y);
    }

    public static void subtraction(){
        System.out.println(x-y);
    }

    public static void multiply(){
        System.out.println(x*y);
    }

    public static void division(){
        System.out.println(x/y);
    }

    public static void division1(){
        int x = 7;
        int y = 3;
        System.out.println(x/y);
    }

    public static void division2(){
        float x = 7;
        float y = 3;
        System.out.println(x/y);
    }

    public static void mdulusDivision(){
        int x = 7;
        int y = 3;
        System.out.println(x%y);
        System.out.println(DataTypes2.x%DataTypes2.y);
    }

    public static void increment(){
        System.out.println("Line 1: "+ ++x);
        System.out.println("Line 2: "+ x++);
        System.out.println("Line 3: "+ x);
        //System.out.println(x);
    }

    public static void decrement(){
        //System.out.println(--y);
        //System.out.println(y);
    }
}
