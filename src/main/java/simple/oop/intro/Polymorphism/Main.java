package simple.oop.intro.Polymorphism;

public class Main {
    public static void main(String[] args) {
//        Animal myAnimal = new Animal(); // Create a Animal object
        Animal myPig = new Pig(); // Create a Pig object
        Animal myDog = new Dog(); // Create a Dog object
//        myAnimal.animalSound();

        myPig.animalSound();
//        myPig.weigth = 10;

        myDog.animalSound();
//        myDog.weigth = 10;
    }
}

