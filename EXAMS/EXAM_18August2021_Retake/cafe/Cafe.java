package ADVANCED.EXAMS.EXAM_18August2021_Retake.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
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

    public void addEmployee(Employee employee) {
        if (capacity > getEmployees()) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        Employee removedEmployee = null;
        for (Employee e : employees) {
            if (e.getName().equals(name)) {
                removedEmployee = e;
            }
        }
        if (removedEmployee == null) {
            return false;
        } else {
            employees.remove(removedEmployee);
            return true;
        }
    }

    public Employee getOldestEmployee() {
        Employee old = null;
        int maxAge = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getAge() > maxAge) {
                maxAge = employee.getAge();
                old = employee;
            }
        }
        return old;
    }

    public Employee getEmployee(String name) {
        Employee employee = null;
        for (Employee e : employees) {
            if (e.getName().equals(name)) {
                employee = e;
            }
        }
        return employee;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Employees working at Cafe %s:", getName())).append("\n");
        for (Employee employee : employees) {
            builder.append(employee.toString()).append("\n");
        }
        return builder.toString();
    }
}

