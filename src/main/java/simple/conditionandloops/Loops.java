package simple.conditionandloops;

public class Loops {

    public static void main(String args[]) {
        doWhileLoopExample();
    }

    public static void forLoopExample() {
        for(int i = 10; i >= 1; i++) {
            System.out.println("The value of i is: " + i);
        }
    }

    public static void forLoopExample2() {
        int arr[] = {2, 11, 45, 9};
        int lastIndex = arr.length-1;
        int length = arr.length;
        //i starts with 0 as array index starts with 0 too
        for (int i = 100; i >= 1; i--) {
            System.out.println(i);
        }

        for (int j = 100; j >= 1; j--) {
            System.out.println(j);
        }
    }

    public static void whileLoopExample() {
        int i = 0;

        while(i < 10){
            System.out.println(i);
            //sleep(100)
            i++;
        }
    }

    public static void doWhileLoopExample() {
        int i = 4;

        do {
            System.out.println(i);
            i--;
        } while (i >= 5);
    }

    public static void doWhileLoopExample2() {
        int arr[] = {2,11,45,9,16};

        //i starts with 0 as array index starts with 0
        int i = 0;
        do {
            System.out.println(arr[i]);
            i++;
        } while(i < 5);
    }

    public static void continueStatementExample() {
        for (int j = 0; j<= 6; j++) {
            System.out.print(j + " ");

            if (j == 4) {
                continue;
            }

            System.out.print(j + " ");
        }
    }

    public static void breakStatementExample() {
        int num = 0;

        while(num <= 100)
        {
            System.out.println("Value of variable is: " + num);
            if (num == 2)
            {
                break;
            }
            num++;
        }

        System.out.println("Out of while-loop");
    }

    public static void breakStatementExample2   () {
        int var;
        for (var = 100; var >= 10; var--)
        {
            System.out.println("var: " + var);

            if (var == 99)
            {
                break;
            }
        }

        System.out.println("Out of for-loop");
    }
}
