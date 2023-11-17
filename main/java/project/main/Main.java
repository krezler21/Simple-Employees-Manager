package project.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.model.ClassEmployee;
import project.model.Employee;
import project.model.EmployeeCondition;

public class Main extends Application {
    public static void main(String[] args) {
        //Dodawanie pracowników
        Employee e1 = new Employee("Konrad","Rezler", EmployeeCondition.PRESENT, 2002, 0);
        Employee e2 = new Employee("Jan","Kowalski", EmployeeCondition.PRESENT, 1984, 5400.53);
        Employee e3 = new Employee("Agata","Kowalczyk", EmployeeCondition.DURING_DELEGATION, 1995, 4378.64);
        Employee e4 = new Employee("Michał","Bylica", EmployeeCondition.PRESENT, 1999, 3800.90);
        Employee e5 = new Employee("Roch","Boryna", EmployeeCondition.PRESENT, 1975, 12_345.67);
        Employee e6 = new Employee("Jagna", "Dominikowa", EmployeeCondition.SICK, 2003, 3500);
        GlobalData.employeesList.add(e1);
        GlobalData.employeesList.add(e2);
        GlobalData.employeesList.add(e3);
        GlobalData.employeesList.add(e4);
        GlobalData.employeesList.add(e5);
        GlobalData.employeesList.add(e6);


        ClassEmployee group1 = new ClassEmployee("Managerzy",3);
        group1.addEmployee(GlobalData.employeesList.get(4));
        group1.addEmployee(GlobalData.employeesList.get(1));
        GlobalData.groupsList.add(group1);

        ClassEmployee group2 = new ClassEmployee("HR",5);
        group2.addEmployee(GlobalData.employeesList.get(2));
        group2.addEmployee(GlobalData.employeesList.get(3));
        GlobalData.groupsList.add(group2);

        ClassEmployee group3 = new ClassEmployee("Stażyści",10);
        group3.addEmployee(GlobalData.employeesList.get(0));
        group3.addEmployee(GlobalData.employeesList.get(5));
        GlobalData.groupsList.add(group3);

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load((getClass().getResource("/fxml/mainPane.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
