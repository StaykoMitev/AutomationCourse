package simple.datastructures;

import java.util.Stack;

public class StackExamples {

    static Stack<String> stackOfStrings = new Stack<>();

    public static void main(String[] args) {
        //addElementToStack();
        //removeLastElementFromStack();
        //getLastElementFromStack();
        //iterateThroughQueue();
        searchInStack();
    }

    public static void addElementToStack(){
        stackOfStrings.push("element1");
        stackOfStrings.push("element2");
        stackOfStrings.push("element3");
        stackOfStrings.push("element4");
        System.out.println(stackOfStrings);
    }

    public static void getLastElementFromStack(){
        stackOfStrings.push("element1");
        stackOfStrings.push("element2");
        stackOfStrings.push("element3");
        System.out.println(stackOfStrings.pop());
    }

    public static void removeLastElementFromStack(){
        stackOfStrings.push("element1");
        stackOfStrings.push("element2");
        stackOfStrings.push("element3");
        stackOfStrings.pop();
        System.out.println(stackOfStrings);
    }

    static void searchInStack(){
        stackOfStrings.push("element1");
        stackOfStrings.push("element2");

        //Search method returns integer - if element with that value is found it returns the index of the element, if not it returns -1;
        int indexOfTheElementSearch1 = stackOfStrings.search("element1");
        if (indexOfTheElementSearch1>0){
            System.out.println("Element found");
        }

        int indexOfTheElementSearch2 = stackOfStrings.search("element7");
        if(indexOfTheElementSearch2 == -1){
            System.out.println("Element with that value not found");
        }
    }

    public static void iterateThroughStack(){
        stackOfStrings.push("element1");
        stackOfStrings.push("element2");
        stackOfStrings.push("element3");
        stackOfStrings.push("element4");
        for(String queueElement: stackOfStrings){
            System.out.println(queueElement);
        }
    }
}
