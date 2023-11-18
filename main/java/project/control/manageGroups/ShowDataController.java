package project.control.manageGroups;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import project.model.ClassEmployee;
import project.model.Employee;

public class ShowDataController extends ManageGroupsController{
    @FXML
    private Text groupNameText;

    @FXML
    private Text numberOfEmployeesText;

    @FXML
    private Text maxEmployeesText;

    @FXML
    private Text fillText;
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
}
