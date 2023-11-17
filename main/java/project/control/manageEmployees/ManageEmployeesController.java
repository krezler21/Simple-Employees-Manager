package project.control.manageEmployees;



import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project.control.Controller;
import project.model.Employee;
import project.model.EmployeeCondition;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManageEmployeesController extends Controller implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        yearOfBirth.setCellValueFactory(new PropertyValueFactory<>("YearOfBirth"));
        salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        condition.setCellValueFactory(new PropertyValueFactory<>("Condition"));

        employeesTable.setItems(employeesList);
    }

    @FXML
    protected void switchToAddEmployee(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/manageEmployees/addEmployee.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void removeEmployee(ActionEvent event) throws IOException{
        ObservableList<Employee> allEmployees, singleEmployee;
        allEmployees = employeesTable.getItems();
        singleEmployee = employeesTable.getSelectionModel().getSelectedItems();
        singleEmployee.forEach(allEmployees::remove);
    }

    @FXML
    protected void switchToChangeCondition(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/manageEmployees/editEmployee.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToSearchPartial(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/manageEmployees/searchPartial.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
