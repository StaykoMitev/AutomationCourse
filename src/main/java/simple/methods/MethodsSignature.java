package simple.methods;

public class MethodsSignature {

    public static void main(String[] args) {
        printValues();
        printValues(5);
        printValues("one");
        printValues("arg1Value","arg2Value");
    }

    public static void printValues(){
        System.out.println("printValues() without parameters");
    }

    public static void printValues(String argument1){
        System.out.println("printValues() with "+argument1+" parameters");
    }

    public static void printValues(String argument1, String argument2){
        System.out.println("printValues() with two args - parameters1: "+argument1+" parameters2: "+argument2);
    }

    public static void printValues(int intArgument){
        System.out.println("printValues() with int parameters "+intArgument);
    }

}
