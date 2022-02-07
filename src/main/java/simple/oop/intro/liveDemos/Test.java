package simple.oop.intro.liveDemos;

public class Test {
    String brand;
    String model;
    double length;
    double width;
    double weight;
    int horsePower;
    int maxSpeed;

    Test(String b, String m, double l, double wi, double we){
        this.brand = b;
        this.model = m;
        this.length = l;
        this.width = wi;
        this.weight = we;
    }

    Test(String brand, String model, int horsePower){
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Test(){
    }

    public String brandPlusModel(){
        return brand+model;
    }
}