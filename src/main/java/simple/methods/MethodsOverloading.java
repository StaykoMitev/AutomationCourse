package simple.methods;

public class MethodsOverloading {

    public static void main(String[] args) {
        System.out.println(sumTwoNumbers(1.5,1.5));
        System.out.println(sumTwoNumbers(2,2));
    }

    static double sumTwoNumbers(double x, double y){
        return x+y;
    }

    static int sumTwoNumbers(int x, int y){
        return x+y;
    }
}
