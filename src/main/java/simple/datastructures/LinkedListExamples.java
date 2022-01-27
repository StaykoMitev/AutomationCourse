package simple.datastructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LinkedListExamples {

    static LinkedList<String> emptyLinkedList = new LinkedList<>();


    public static void main(String[] args) {
        //addElementToLinkedList();
        //removeElementFromAnArrayList();
        addElementToLinkedList();
    }

    public static void addElementToLinkedList(){
        emptyLinkedList.add("1");
        emptyLinkedList.add("2");
        emptyLinkedList.add("3");
        emptyLinkedList.addFirst("0");
        emptyLinkedList.addLast("4");
        for (String arrayListString : emptyLinkedList) {
            System.out.print(arrayListString+" ");
        }
    }

    public static void removeElementFromAnArrayList(){
        emptyLinkedList.add("Volvo");
        emptyLinkedList.add("Mercedes");
        emptyLinkedList.add("Opel");
        emptyLinkedList.add("Nissan");

        System.out.println(emptyLinkedList);

        emptyLinkedList.remove(0);
        emptyLinkedList.removeFirst();
        emptyLinkedList.removeLast();
        emptyLinkedList.removeIf(n -> Objects.equals(n, "oo"));
        System.out.println("Elements in the linkedList after removal: "+emptyLinkedList);

        emptyLinkedList.removeIf(n ->Objects.equals(n,"Opel"));
        System.out.println("Size of the linkedList after removeIf element == opel: "+emptyLinkedList.size());
    }

}
