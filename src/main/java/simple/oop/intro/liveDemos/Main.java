package simple.oop.intro.liveDemos;

public class Main  {
    public static void main(String[] args) {

//        System.out.println(obj1.x);
//
//        Test obj2 = new Test();
//        System.out.println(obj2.x);
//
//        obj1.printHelloOfObject();
//        obj2.printHelloOfObject();
//
//        Test.printHello();

        Test c = new Test("BMW", "440", 4.20, 1.2, 3000);
        System.out.println(c.brand);

        Test c1 = new Test("BMW", "440", 300);
        c1.length = 4.50;
    }
}

