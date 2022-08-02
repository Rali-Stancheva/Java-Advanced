package ADVANCED.EXAMS.EXAM_16_December_2020.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEmployees() {
        return employees.size();
    }

    public void add(Employee employee) {
        if (capacity > getEmployees()) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        Employee empToRemove = null;
        for (Employee element : employees) {
            if (element.getName().equals(name)) {
                empToRemove = element;
            }
        }
        if (empToRemove == null) {
            return false;
        } else {
            employees.remove(empToRemove);
            return true;
        }
    }

    //!!!
    public Employee getOldestEmployee() {
        Employee employee = null;
        int oldest = Integer.MIN_VALUE;
        for (Employee element : employees) {
            if (element.getAge() > oldest) {
                oldest = element.getAge();
                employee = element;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name) {
        Employee emp = null;
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                emp = employee;
            }
        }
        return emp;
    }

    public int getCount(){
       return employees.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Employees working at Bakery %s:\n",name));
        for (Employee employee : employees) {
            builder.append(employee.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
