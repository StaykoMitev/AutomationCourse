package simple.oop.intro;

import simple.oop.intro.liveDemos.Test;

public class Dog extends Test {
    public String name;
    public int age;
    protected static String breed;
    static String color;

//    public Dog (String name, int age, String breed, String color){
//        this.name = name;
//        this.age = age;
//        this.breed = breed;
//        this.color = color;
//    }


    public static void bark(){
        System.out.println("Bark");
    }

    public void eat(){
        System.out.println("Eat");
    }

    public void sleep(){
        System.out.println("Sleep");
    }
}
