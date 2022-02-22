package DEMO.ObjectsAndClasses_MoreExercise.CompanyRoster;

import java.util.List;

public class Department {

    private String name;
    private List<Employee> employeeFromEmployeeList;
    private double avgSalary;

    public Department(String name, List<Employee> employeeFromEmployeeList) {
        this.name = name;
        this.employeeFromEmployeeList = employeeFromEmployeeList;
        this.avgSalary = employeeFromEmployeeList.stream()
                .mapToDouble(Employee::getSalary).average().orElse(0.00);
    }


    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeFromEmployeeList() {
        return employeeFromEmployeeList;
    }

    public double getAvgSalary() {
        return avgSalary;
    }
}
