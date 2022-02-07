package simple.oop.intro.Inheritance;

public class ElectricCar extends Car {
    private int batteryCapacity;
    private boolean isDoorClosed = true;

    ElectricCar(String brand, String model, double length, double width, double weight, int batteryCapacity) {
        super(brand, model, length, width, weight);

        this.batteryCapacity = batteryCapacity;
    }

    public void closeOpenDoor() {
        this.isDoorClosed = !isDoorClosed;
        if(this.isDoorClosed) {
            System.out.println("The door is closed");
        } else {
            System.out.println("The door is opened");
        }
    }

    public int getBatteryCapacity(){
        return batteryCapacity;
    }

    public void honk(){
        System.out.println("Beep Beep Electric");
    }
}
