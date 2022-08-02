package ADVANCED.EXERCISE6_Defining_Classes.P2_Company_Roster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Employee>> departmentsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] personInfo = scan.nextLine().split("\\s+");
            String name = personInfo[0];
            double salary = Double.parseDouble(personInfo[1]);
            String position = personInfo[2];
            String department = personInfo[3];

            Employee employee = null;

            if (personInfo.length == 6) {
                String email = personInfo[4];
                int age = Integer.parseInt(personInfo[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (personInfo.length == 5) {
                String forthParameter = personInfo[4];
                if (forthParameter.contains("@")) {
                    String email = forthParameter;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(forthParameter);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (personInfo.length == 4) {
                employee = new Employee(name, salary, position, department);
            }

            //отделът на служителя да го няма
            if (!departmentsMap.containsKey(department)) {
                departmentsMap.put(department, new ArrayList<>());
                departmentsMap.get(department).add(employee);
            } else {
                departmentsMap.get(department).add(employee);
            }
        }

        String maxAverageSalaryDepartment = departmentsMap.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> gerAverageSalary(entry.getValue())))
                .get()//entry (отдел -> списък със служителите): отделът с най-висока заплата
                .getKey();

        System.out.printf("Highest Average Salary: %s\n",maxAverageSalaryDepartment);
        List<Employee> employeeList = departmentsMap.get(maxAverageSalaryDepartment);
        employeeList.sort(Comparator.comparingDouble(employee -> employee.getSalary()));
        Collections.reverse(employeeList);

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public static double gerAverageSalary(List<Employee> employees) {
        //сума от заплатите / бр. служителите
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}
