package simple.oop.intro.Inheritance;

public class Car {
    String brand;
    String model;
    double length;
    double width;
    double weight;
    int horsePower;
    int maxSpeed;

    Car(String brand, String model, double length, double width, double weight){
        this.brand = brand;
        this.model = model;
        this.length = length;
        this.width = width;
        this.weight = weight;
    }

    protected void honk() {
        System.out.println("beep beep");
    }
}
