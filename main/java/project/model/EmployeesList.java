package project.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeesList {
    public static ObservableList<Employee> employeesList = FXCollections.observableArrayList(
            new Employee("Konrad", "Rezler", EmployeeCondition.PRESENT, 2002, 0),
            new Employee("Jan", "Kowalski", EmployeeCondition.PRESENT, 1984, 5400.53),
            new Employee("Agata", "Kowalczyk", EmployeeCondition.DURING_DELEGATION, 1995, 4378.64),
            new Employee("Michał", "Bylica", EmployeeCondition.PRESENT, 1999, 3800.90),
            new Employee("Roch", "Boryna", EmployeeCondition.PRESENT, 1975, 12_345.67)
    );
}
