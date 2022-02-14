package simple.oop.intro.Abstraction;

// Subclass (inherit from Animal)
abstract class Pig extends Animal {
    abstract String getColor();

    public void animalSound(){
        System.out.println("");
    }

}

class HomePig extends Pig {

    @Override
    String getColor() {
        return "Pink";
    }
}

class Main {

    public static void main(String[] args) {
        HomePig hp = new HomePig();
        hp.getColor();
    }
}