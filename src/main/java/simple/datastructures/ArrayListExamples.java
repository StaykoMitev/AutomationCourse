package simple.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class ArrayListExamples {

    static ArrayList<String> arrayListOfStrings = new ArrayList<>();

    public static void main(String[] args) {
        //addElementToArrayList();
        //removeElementFromTheArrayList();
        //changeElementValueInTheArrayList();
        //getArrayListSize();
        //removeElementsFromTheArrayListAndGetSize();
        //sortAnArray();
    }

    public static void addElementToArrayList(){
        arrayListOfStrings.add("firstElement");
        System.out.println(arrayListOfStrings.get(0));
    }

    public static void removeElementFromTheArrayList(){
        arrayListOfStrings.add("firstElement");
        arrayListOfStrings.add("secondElement");
        arrayListOfStrings.remove(0);
        System.out.println(arrayListOfStrings.get(0));
    }

    public static void changeElementValueInTheArrayList(){
        arrayListOfStrings.add("firstElement");
        arrayListOfStrings.set(0,"firstElement-changed");
        System.out.println(arrayListOfStrings.get(0));
    }

    public static void getArrayListSize(){
        arrayListOfStrings.add("first");
        arrayListOfStrings.add("second");
        arrayListOfStrings.add("third");
        System.out.println(arrayListOfStrings.size());
    }

    public static void removeElementsFromTheArrayListAndGetSize(){
        arrayListOfStrings.add("first");
        arrayListOfStrings.add("second");
        arrayListOfStrings.add("third");
        arrayListOfStrings.clear();
        System.out.println(arrayListOfStrings.size());
    }

    public static void sortAnArray(){
        arrayListOfStrings.add("3");
        arrayListOfStrings.add("1");
        arrayListOfStrings.add("2");

        System.out.print("Order before the sorting: ");
        for (String arrayListString : arrayListOfStrings) {
            System.out.print(arrayListString);
        }

        Collections.sort(arrayListOfStrings);
        System.out.println("");

        System.out.print("Order after the sorting: ");
        ListIterator<String> listItr = arrayListOfStrings.listIterator();

        while(listItr.hasNext()){
            System.out.print(listItr.next());
        }
    }
}
