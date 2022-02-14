package simple.oop.intro.Inheritance;

import simple.oop.intro.Encapsulation.BankAccount;

class Main {
    public static void main(String[] args) {


        Car normalCar = new Car("BMW", "440", 4300, 1200, 1700);
        normalCar.honk();

        ElectricCar tesla = new ElectricCar("Tesla", "X", 4500, 120, 3000, 110);
        tesla.closeOpenDoor();
        tesla.closeOpenDoor();
        tesla.closeOpenDoor();

        System.out.println();
//
//        tesla.closeOpenDoor();
//        tesla.closeOpenDoor();
//        tesla.honk();
    }
}
