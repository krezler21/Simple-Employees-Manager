package project.model;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
    private String firstName;
    private String lastName;
    private Integer yearOfBirth;
    private Double salary;
    private EmployeeCondition condition;

    public Employee(String fistName, String lastName, EmployeeCondition condition, int yearOfBirth, double salary) {
        this.firstName = fistName;
        this.lastName = lastName;
        this.condition = condition;
        this.yearOfBirth = yearOfBirth;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeCondition getCondition() {
        return condition;
    }

    public void setCondition(EmployeeCondition condition) {
        this.condition = condition;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void printing(){
        StringBuilder text = new StringBuilder("Pełne informacje o pracowniku:\n");
        text.append("Imię: ").append(this.firstName).append("\n");
        text.append("Nazwisko: ").append(this.lastName).append("\n");
        text.append("Rok urodzenia: ").append(this.yearOfBirth).append("\n");
        text.append("Wynagrodzenie: ").append(this.salary).append("\n");
        text.append("Stan pracownika: ").append(this.condition.getDescription()).append("\n");

        System.out.println(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return yearOfBirth == employee.yearOfBirth && Double.compare(employee.salary, salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && condition == employee.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, yearOfBirth, salary, condition);
    }

    @Override
    public int compareTo(Employee employee) {
        return this.lastName.compareTo(employee.lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
