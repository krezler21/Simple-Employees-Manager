package project.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.model.ClassEmployee;
import project.model.Employee;

public class GlobalData {
    public static ObservableList<Employee> employeesList = FXCollections.observableArrayList();
    public static ObservableList<ClassEmployee> groupsList = FXCollections.observableArrayList();
}
