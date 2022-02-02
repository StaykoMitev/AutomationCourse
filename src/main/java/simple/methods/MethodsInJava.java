package simple.methods;

public class MethodsInJava {

    static String firstName = "firstName";

    String lastName = "lastName";
    final String url = "myURL.com";
    final String url1 = "anotherUrl.com";

    double firstNumber;
    double secondNumber;
    double thridNumber;

    public static void main(String[] args) {
        MethodsInJava mij = new MethodsInJava();

        System.out.println(mij.returnMid(1,2,3));
    }

    double returnMid(double firstNumber1, double secondNumber, double thridNumber){
        this.firstNumber = firstNumber1;
        this.secondNumber = secondNumber;
        this.thridNumber = thridNumber;

        if(firstNumber<secondNumber && firstNumber<thridNumber) {
            return firstNumber;
        }else if(secondNumber < firstNumber && secondNumber <thridNumber){
            return secondNumber;
        }else return this.thridNumber;
    }

    public static String getFirstName(){
        return firstName;
    }

    public void methodsInJavaFiled(){
        System.out.println(lastName);
    }

//    public String changeURL(){
//        return url = "new value";
//    }

    public void changeUrlRef(){
       // url = url1;
    }

    static double returnMin(){
        int a = 1;
        int b = 2;
        int c = 3;
        if(a<b && a<c) {
            return a;
        }else if(b < a && b <c){
            return b;
        }else return c;
    }

    static double returnMin(double firstNumber, double b, double c){
        if(firstNumber<b && firstNumber<c) {
            return firstNumber;
        }else if(b < firstNumber && b <c){
            return b;
        }else return c;
    }
}
