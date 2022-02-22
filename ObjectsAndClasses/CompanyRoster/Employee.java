package DEMO.ObjectsAndClasses_MoreExercise.CompanyRoster;

public class Employee {

    //name, salary, position, department, email, and age.
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
