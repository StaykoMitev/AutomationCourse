package simple.conditionandloops;

public class ConditionalStatements {
    public static void main(String args[]) {
        ifStatementExample();
        nestedIfStatementExample();
        switchCaseExample("33");
    }

    public static void ifStatementExample() {
        int num = 70;

        if (num < 100) {
            System.out.print("number is less than 100");
        }
    }

    public static void nestedIfStatementExample() {
        int num = 101;

        if (num < 100) {
            System.out.println("number is less than 100");

            if (num > 50) {
                System.out.println("number is greater than 50");
            }
        }

    }

    public static void ifElseExample() {
        int i = 50;

        if (i < 50){
            System.out.println("number is less than 50");
        }
        else {
            System.out.println("number is bigger than or equal to 50");
        }
    }

    public static void ifElseIfExample() {
        int num=100000;

        if (num <100 && num>9) {
            System.out.println("Its a two digit number");
        } else if(num <10 && num>=0) {
            System.out.println("Its a one digit number");
        } else if(num <1000 && num>=100) {
            System.out.println("Its a three digit number");
        } else if(num <10000 && num>=1000) {
            System.out.println("Its a four digit number");
        } else {
            System.out.println("number is not between 1 & 9999");
        }
    }

    public static void switchCaseExample(String s) {
        String s1="1";

        switch(s) {
            case "1": {
                System.out.println("Case1 ");
                break;
            }
            case "2": {
                System.out.println("Case2 ");
                break;
            }
            case "3": {
                System.out.println("Case3 ");
                break;
            }
            default:
                System.out.println("Default ");
        }

        if (s.equals(s1)){}
    }
}
