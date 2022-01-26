package simple.datatypes;

public class DataTypes {

    //declare vars

    static byte myByte = 56;
    static short myShort = 5100;
    static int myInt = 1000004;
    static long myLong = 12312331;
    static double myDouble = 4.5546467834547;
    static float myFloat = 4.55654f;
    static boolean myBoolean = true;
    static char myChar = 'c';
    static String s1 = new String("string value");
    static String s2 = "string value";
    static String s3 = s1+s2;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter username");
//
//        String userName = scanner.nextLine();
//        System.out.println("Entered username is: "+userName);
        addition();
        subtraction();
        multiplication();
        division();
        divisionRemainder();
        divideFloat();
        divideInt();
        divideInts();
        increment();
        decrement();
    }

    public static void addition(){
        int x = 5;
        int y = 3;
        System.out.println(x+y);
    }

    public static void subtraction(){
        int x = 3;
        int y = 5;
        System.out.println(x-y);
    }

    public static void multiplication(){
        int x = 3;
        int y = 5;
        System.out.println(x*y);
    }

    public static void division(){
        float y = 5;
        float x = 3;
        System.out.println("divide float" + y/x);
    }

    public static void divideInt(){
        int y = 5;
        float x = 3;
        System.out.println("divide int "+ y/x);
    }

    public static void divideInts(){
        int y = 7;
        int x = 3;
        System.out.println("divide ints "+ y/x);
    }

    public static void divideFloat(){
        float y = 5;
        int x = 3;
        System.out.println("divide float "+y/x);
    }

    public static void divisionRemainder(){
        float y = 5;
        float x = 3;
        System.out.println(y%x);
    }

    public static void increment(){
        int x = 5;
        System.out.println("increment "+ ++x);
    }

    public static void decrement(){
        int x =5;
        System.out.println("decrement "+ --x);
    }
}
