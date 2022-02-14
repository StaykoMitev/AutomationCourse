package simple.oop.intro.Encapsulation;

class Main {
    public static void main(String[] args) {
        BankAccount dv = new BankAccount("Dimitar Vasilev");

        dv.makeTransaction(1500);

        System.out.println(dv.getAccountNumber());
        System.out.println("Account balance: " + dv.getAccountBalance());

        dv.makeTransaction(-300);
        System.out.println("Account balance: " + dv.getAccountBalance());


        BankAccount ii = new BankAccount("Ivan Ivanov", 1400);
        System.out.println(ii.getAccountBalance());

//        ii.setAccountNumber("PP");
        System.out.println(ii.getAccountNumber());

    }
}
