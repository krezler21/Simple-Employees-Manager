package project.control.manageGroups;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import project.control.Controller;
import project.model.ClassEmployee;
import project.model.Employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageGroupsController extends Controller implements Initializable {

    @FXML
    private ListView<ClassEmployee> groupsListView;

    @FXML
    private Text groupNameText;

    @FXML
    private Text numberOfEmployeesText;

    @FXML
    private Text maxEmployeesText;

    @FXML
    private Text fillText;

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
            resultEmployeesList.addAll(singleGroup.get(0).getGroupOfEmployees());

            employeesTable.setItems(resultEmployeesList);
            groupNameText.setText(singleGroup.get(0).getGroupName());
            numberOfEmployeesText.setText(String.valueOf(singleGroup.get(0).getGroupOfEmployees().size()));
            maxEmployeesText.setText(String.valueOf(singleGroup.get(0).getMaxEmployees()));
            double percent = (double) (singleGroup.get(0).getGroupOfEmployees().size()) / singleGroup.get(0).getMaxEmployees();
            String fill = String.format("%.2f%%", percent * 100);
            fillText.setText(fill);
        } catch (Exception e) {
            createAlert("Select a group first");
        }
    }

    @FXML
    protected void removeGroup(ActionEvent event) throws IOException {
        ObservableList<ClassEmployee> allGroups, singleGroup;
        allGroups = groupsListView.getItems();
        singleGroup =groupsListView.getSelectionModel().getSelectedItems();
        singleGroup.forEach(allGroups::remove);

        switchToManageGroups(event);
    }



}
