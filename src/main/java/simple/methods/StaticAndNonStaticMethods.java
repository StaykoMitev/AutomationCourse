package simple.methods;

public class StaticAndNonStaticMethods {

    public static void main(String[] args) {
        StaticAndNonStaticMethods object = new StaticAndNonStaticMethods();
        object.printValueNoneStatic("none static method");

        printValue("static method");
    }

    public static void printValue(String parameter){
        System.out.println("Here is the entered value: "+parameter);
    }

    public void printValueNoneStatic(String parameter){
        System.out.println("Here is the entered value: "+parameter);
    }
}
