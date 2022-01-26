package simple.operators;

public class AssignmentOperators {

    static int num1 = 10;
    static int num2 = 20;

    public static void main(String[] args) {
        //assignOperator();
        //sumAndAssign();
        //minusAndAssign();
    }

    public static void  assignOperator(){
        System.out.println(num1=num2);
    }

    public static void sumAndAssign(){
        System.out.println(num1+=num2);
    }

    public static void minusAndAssign(){
        System.out.println(num1-=num2);
    }

    public static void multiAndAssign(){
        System.out.println(num1*=num2);
    }

    public static void divideAndAsiign(){
        System.out.println(num2/=num1);
    }

    public static void moduleAndAssign(){
        System.out.println(num2%=num1);
    }
}
