package project.model;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class ClassEmployee {
    private String groupName;
    private int maxEmployees = 10;
    private ArrayList<Employee> groupOfEmployees = new ArrayList<>();

    public ClassEmployee(String groupName) {
        this.groupName = groupName;
    }

    public ClassEmployee(String groupName, int maxEmployees) {
        this.groupName = groupName;
        this.maxEmployees = maxEmployees;
    }

    public ClassEmployee(String groupName, int maxEmployees, ArrayList<Employee> groupOfEmployees) {
        this.groupName = groupName;
        this.maxEmployees = maxEmployees;
        this.groupOfEmployees = groupOfEmployees;
    }

    public void addEmployee(Employee employee){
        if(!(groupOfEmployees.size()==maxEmployees)){
            if(!groupOfEmployees.contains(employee)){
                groupOfEmployees.add(employee);
            } else {
                System.err.println("W grupie już znajduje się pracownik " + employee);
            }
        } else {
            System.err.println("Grupa osiągnęła maksymalny rozmiar.");
        }
    }

    public void addSalary(Employee employee, double salary){
        for (Employee employeeFromGroup : groupOfEmployees) {
            if(employeeFromGroup.equals(employee)){
                employeeFromGroup.setSalary(salary);
                System.out.println("Zmieniono wynagrodzenie pracownika " + employee + " na wartość " + salary);
            }
        }
    }

    public void removeEmployee(Employee employee){
        groupOfEmployees.remove(employee);
        System.out.println("Usunięto pracownika " + employee);
    }

    public void changeCondition(Employee employee, EmployeeCondition condition){
        for (Employee employeeFromGroup : groupOfEmployees) {
            if(employeeFromGroup.equals(employee)){
                employeeFromGroup.setCondition(condition);
            }
        }
    }



    public void searchPartial(String partialName){
        System.out.println("Pracownicy z fragmentem \"" + partialName + "\":");
        boolean employeeExist = false;
        for (Employee employeeFromGroup : groupOfEmployees) {
            if(employeeFromGroup.getFirstName().contains(partialName)||employeeFromGroup.getLastName().contains(partialName)){
                employeeFromGroup.printing();
                employeeExist = true;
            }
        }

        if(!employeeExist){
            System.out.println("Brak pracowników z fragmentem \"" + partialName + "\"");
        }
    }

    public void countByCondition(EmployeeCondition condition){
        int counter = 0;
        for (Employee employeeFromGroup : groupOfEmployees) {
            if(employeeFromGroup.getCondition().equals(condition)){
                counter++;
            }
        }

        System.out.println("Liczba pracowników w stanie \"" + condition.getDescription() + "\": " + counter);
    }

    public void summary(){
        System.out.println("Nazwa grupy: " + groupName);
        System.out.println("Pracownicy w grupie:");
        boolean lackOfEmployees = true;
        for (Employee employee : groupOfEmployees) {
            employee.printing();
            lackOfEmployees = false;
        }

        if(lackOfEmployees){
            System.out.println("Brak pracowników");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassEmployee that = (ClassEmployee) o;
        return maxEmployees == that.maxEmployees && Objects.equals(groupName, that.groupName) && Objects.equals(groupOfEmployees, that.groupOfEmployees);
    }

    @Override
    public String toString() {
        return groupName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, maxEmployees, groupOfEmployees);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) {
        this.maxEmployees = maxEmployees;
    }

    public ArrayList<Employee> getGroupOfEmployees() {
        return groupOfEmployees;
    }

    public void setGroupOfEmployees(ArrayList<Employee> groupOfEmployees) {
        this.groupOfEmployees = groupOfEmployees;
    }
}
