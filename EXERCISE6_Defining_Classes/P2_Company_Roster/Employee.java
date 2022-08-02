package ADVANCED.EXERCISE6_Defining_Classes.P2_Company_Roster;

public class Employee {
    //задължително ги има
    private String name;
    private double salary;
    private String position;
    private String department;

    private String email;
    private int age;

    //ако са 4
    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    //ако са 5 с email
    public Employee(String name, double salary, String position, String department,String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = -1;
    }

    //ако са 5 с age
    public Employee(String name, double salary, String position, String department,int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = age;
    }

    //ако са 6
    public Employee(String name, double salary, String position, String department,String email,int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString(){
        return name + " " + String.format("%.2f", salary) + " " + email + " " + age;
    }
}
