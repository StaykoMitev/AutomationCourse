package simple.oop.intro.Exercises;

import java.util.Calendar;

public class Person {
    public String name;
    public String sex;
    public String religion;
    public String languageSpoken;
    public String job;
    public String nationality;
    public String egn;
    public String country;
    private String dateOfBirth;
    private int age;

    public Person(String name, String sex, String religion, String languageSpoken, String job, String nationality, String egn, String country){
        this.name = name;
        this.sex = sex;
        this.religion = religion;
        this.languageSpoken = languageSpoken;
        this.job = job;
        this.nationality = nationality;
        this.egn = egn;
        this.country = country;

        setAge();
        setDOB();
    }
    public void sayHello(){
        System.out.println("Hello");
    }

    public boolean celebrateEaster(){
        if (religion.equals("Christianity")) return true;
        else return false;
    }

    public boolean isAdult() {
        if (age >= 18) {
            if (!country.equals("US")){
                return true;
            } else {
                if (age >= 21 ) return true;
                else return false;
            }
        } else return false;
    }

    public boolean canTakeLoan(){
        if (job.equals("IT")) return true;
        else return false;
    }

    private void setAge(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int twoDigits = Integer.valueOf(egn.substring(0, 2));
        String prefix = "19";

        if (twoDigits <= 22) prefix = "20";

        age = year - Integer.valueOf(prefix + twoDigits);
    }

    private void setDOB(){
        int yearTwoDigits = Integer.valueOf(egn.substring(0, 2));
        String year;

        if (yearTwoDigits <= 22) year = "20" + yearTwoDigits;
        else year = "19" + yearTwoDigits;

        String month = egn.substring(2, 4);
        String day = egn.substring(4, 6);

        dateOfBirth = day + "/" + month + "/" + year;
    }

    public String getAge(){
        return String.valueOf(age);
    }

    public String getDOB(){
        return dateOfBirth;
    }
}
