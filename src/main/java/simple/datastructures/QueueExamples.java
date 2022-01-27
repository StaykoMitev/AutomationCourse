package simple.datastructures;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExamples {
    static Queue<String> queueOfStrings = new PriorityQueue<>();

    public static void main(String[] args) {
        //addElementsToQueue();
        //getFirstElementFromQueue();
        removeFirstElementFromQueue();
        //iterateThroughQueue();
    }

    public static void addElementsToQueue(){
        queueOfStrings.add("element1");
        queueOfStrings.add("element2");
        queueOfStrings.add("element3");
        queueOfStrings.add("element4");
        System.out.println(queueOfStrings);
    }

    public static void getFirstElementFromQueue(){
        queueOfStrings.add("element1");
        queueOfStrings.add("element2");
        queueOfStrings.add("element3");
        System.out.println(queueOfStrings.peek());
    }

    public static void removeFirstElementFromQueue(){
        queueOfStrings.add("element1");
        queueOfStrings.add("element2");
        queueOfStrings.add("element3");
        System.out.println("Elements before removal: "+queueOfStrings);
        queueOfStrings.poll();
        System.out.println("Elements after removal: "+queueOfStrings);
    }

    public static void iterateThroughQueue(){
        queueOfStrings.add("element1");
        queueOfStrings.add("element2");
        queueOfStrings.add("element3");
        for(String queueElement: queueOfStrings){
            System.out.println(queueElement);
        }
    }
}
