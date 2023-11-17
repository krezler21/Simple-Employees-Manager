package project.control.manageGroups;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import project.control.Controller;
import project.model.ClassEmployee;
import project.model.Employee;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageGroupsController extends Controller implements Initializable {

    @FXML
    private ListView<ClassEmployee> groupsListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        yearOfBirth.setCellValueFactory(new PropertyValueFactory<>("YearOfBirth"));
        salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        condition.setCellValueFactory(new PropertyValueFactory<>("Condition"));

        groupsListView.setItems(groupsList);
    }

    @FXML
    protected void showGroupData(ActionEvent event){
        try{
            ObservableList<ClassEmployee> singleGroup;
            ObservableList<Employee> resultEmployeesList = FXCollections.observableArrayList();

            singleGroup = groupsListView.getSelectionModel().getSelectedItems();
            ArrayList<Employee> temporaryList = singleGroup.get(0).getGroupOfEmployees();

            resultEmployeesList.addAll(temporaryList);

            employeesTable.setItems(resultEmployeesList);
        } catch (Exception e) {
            createAlert("Select a group first");
        }
    }



}
