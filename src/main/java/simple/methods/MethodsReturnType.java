package simple.methods;

public class MethodsReturnType {

    public static void main(String[] args) {

        printMethod();
        System.out.println(sumTwoInt(5,10));
        System.out.println(reverseString("123456789"));
        System.out.println(isNumberEven(25));
        System.out.println(isNumberEven(24));
    }

    public static void printMethod(){
        System.out.println("voidMethod");
    }

    public static int sumTwoInt(int a, int b){
        return a+b;
    }

    public static String reverseString(String string){
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }

    public static boolean isNumberEven(int number){
        return number%2==0;
    }
}
