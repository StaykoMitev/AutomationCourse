package simple.oop.intro.Abstraction;

// Interface
interface Animal_1 {
    // interface method (does not have a body)
    public void animalSound();
    // interface method (does not have a body)
    public void sleep();
}

interface AnimalI_2 {
    // interface method (does not have a body)
    public void eats();
    // interface method (does not have a body)
    public void roars();
}

// Pig "implements" the Animal interface
abstract class PigI implements Animal_1 ,AnimalI_2 {

    public void sleep() {
        // The body of sleep() is provided here
        System.out.println("Zzz");
    }
}

class Pig2 extends PigI {

    @Override
    public void animalSound() {

    }

    @Override
    public void eats() {

    }

    @Override
    public void roars() {

    }
}

class MyMainClassI {
    public static void main(String[] args) {
//        PigI myPig = new PigI(); // Create a Pig object
//        myPig.animalSound();
//        myPig.sleep();
    }
}
