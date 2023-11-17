package project.control;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import project.model.ClassEmployee;
import project.model.Employee;
import project.main.GlobalData;

import java.io.IOException;
import java.util.Objects;

public class Controller{
    protected Stage stage;
    protected Scene scene;

    protected ObservableList<Employee> employeesList = GlobalData.employeesList;
    protected ObservableList<ClassEmployee> groupsList = GlobalData.groupsList;


    @FXML
    protected void switchToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/mainPane.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToManageEmployees(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/manageEmployees/manageEmployees.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToManageGroups(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/manageGroups/manageGroups.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exitApplication(ActionEvent event) throws IOException{
        javafx.application.Platform.exit();
    }

    protected void createAlert(String information){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(information);

        alert.showAndWait();
    }

}
