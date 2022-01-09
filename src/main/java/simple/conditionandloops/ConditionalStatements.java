package simple.conditionandloops;

public class ConditionalStatements {
    public static void main(String args[]) {
        nestedIfStatementExample();
    }

    public static void nestedIfStatementExample() {
        int num=70;

        if( num < 100 ) {
            System.out.println("number is less than 100");

            if(num > 50) {
                System.out.println("number is greater than 50");
            }
        }
    }

    public static void ifStatementExample() {
        int num = 70;

        if (num < 100 ) {
            System.out.print("number is less than 100");
        }
    }

    public static void ifElseIfExample() {
        int num=1234;

        if (num <100 && num>=1) {
            System.out.println("Its a two digit number");
        } else if(num <1000 && num>=100) {
            System.out.println("Its a three digit number");
        } else if(num <10000 && num>=1000) {
            System.out.println("Its a four digit number");
        } else {
            System.out.println("number is not between 1 & 99999");
        }
    }

    public static void switchCaseExample() {
        int i = 2;

        switch(i) {
            case 1: {
                System.out.println("Case1 ");
                break;
            }
            case 2: {
                System.out.println("Case2 ");
                break;
            }
            case 3: {
                System.out.println("Case3 ");
                break;
            }
            default:
                System.out.println("Default ");
        }
    }
}
