package simple.oop.intro.Exercises;

public class Main {

    public static void main(String[] args) {
        Person p = new Person("Dimitar", "Male", "Christianity", "any", "IT", "Bulgarian", "8902092020", "Bulgaria");

        System.out.println(p.canTakeLoan());
        System.out.println(p.celebrateEaster());
        System.out.println(p.isAdult());
        System.out.println(p.getAge());
        System.out.println(p.getDOB());

    }

}
