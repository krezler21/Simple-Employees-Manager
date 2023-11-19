package project.control;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import project.model.ClassEmployee;
import project.model.Employee;
import project.main.GlobalData;
import project.model.EmployeeCondition;

import java.io.IOException;
import java.util.Objects;

public class Controller{
    protected Stage stage;
    protected Scene scene;

    protected ObservableList<Employee> employeesList = GlobalData.employeesList;
    protected ObservableList<ClassEmployee> groupsList = GlobalData.groupsList;

    @FXML
    protected TableView<Employee> employeesTable;

    @FXML
    protected TableColumn<Employee, String> firstName;

    @FXML
    protected TableColumn<Employee, String> lastName;

    @FXML
    protected TableColumn<Employee, Integer> yearOfBirth;

    @FXML
    protected TableColumn<Employee, Double> salary;

    @FXML
    protected TableColumn<Employee, EmployeeCondition> condition;


    @FXML
    protected void switchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/mainPane.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToManageEmployees(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/manageEmployees/manageEmployees.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToManageGroups(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/manageGroups/manageGroups.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void exitApplication(ActionEvent event) throws IOException{
        javafx.application.Platform.exit();
    }

    protected void createAlert(String information){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(information);

        alert.showAndWait();
    }

    @FXML
    protected void aboutAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("App was made by Konrad Rezler");

        alert.showAndWait();
    }


}
