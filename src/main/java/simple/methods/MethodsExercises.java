package simple.methods;

public class MethodsExercises {

    public static void main(String[] args) {
        System.out.println("smallestNumber: "+smallestNumber(9,3,1));
        System.out.println("averageNumber: "+ averageNumber(3,5,10));
        displayMiddleCharsFromString("aaaBaaa");
        displayMiddleCharsFromString("aaZZaa");
        System.out.println(countWords("One two three four five"));
        System.out.println(isNumberEven(25));
        System.out.println(isNumberEven(22));
    }

    //Exercise 1
    public static int smallestNumber(int number1, int number2, int number3){
        if(number1 < number2 && number1 < number3){
            return number1;
        }else if (number2 < number1 &&number2 < number3){
            return  number2;
        } else return number3;
    }

    //Exercise 2
    public static int averageNumber(int number1, int number2, int number3){
        return (number1+number2+number3)/3;
    }

    //Exercise 3
    public static void displayMiddleCharsFromString(String string){
        if(string.length()%2 == 1){
            int index = (string.length()/2);
            System.out.println(string.charAt(index));
        } else {
            int index = (string.length())/2;
            System.out.println(string.charAt(index-1)+""+string.charAt(index));
        }
    }

    //Exercise 4
    public static int countWords(String sentence){
        return sentence.split(" ").length;
    }

    //Exercise 5
    public static boolean isNumberEven(int number){
        return number%2==0;
    }

    //Exercise 6
    public static boolean isPalindrome(int number){
        return false;
    }
}
