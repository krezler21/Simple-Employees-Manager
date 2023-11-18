package project.control.manageGroups;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import project.model.ClassEmployee;
import project.model.Employee;
import project.model.EmployeeCondition;

import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

public class EditGroupController extends ManageGroupsController{

   ObservableList<ClassEmployee> selectedGroup = FXCollections.observableArrayList();;

    @FXML
    private Label titleLabel;

    @FXML
    protected TableView<Employee> groupTable;

    @FXML
    protected TableColumn<Employee, String> groupFirstName;

    @FXML
    protected TableColumn<Employee, String> groupLastName;

    @FXML
    protected TableColumn<Employee, Integer> groupYearOfBirth;

    @FXML
    protected TableColumn<Employee, Double> groupSalary;

    @FXML
    protected TableColumn<Employee, EmployeeCondition> groupCondition;

    @FXML
    private TextField newGroupNameTextField;

    @FXML
    private TextField newGroupCapacityTextField;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void initializeEditGroup() {
        groupFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        groupLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        groupYearOfBirth.setCellValueFactory(new PropertyValueFactory<>("YearOfBirth"));
        groupSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        groupCondition.setCellValueFactory(new PropertyValueFactory<>("Condition"));

        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        yearOfBirth.setCellValueFactory(new PropertyValueFactory<>("YearOfBirth"));
        salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        condition.setCellValueFactory(new PropertyValueFactory<>("Condition"));

        ObservableList<Employee> temporaryList= FXCollections.observableArrayList();
        temporaryList.addAll(selectedGroup.get(0).getGroupOfEmployees());

        groupTable.setItems(temporaryList);
        employeesTable.setItems(employeesList);
    }



    public void setTitleLabel(String groupName){
        titleLabel.setText("Editing group: " + groupName);
    }

    public void setSelectedGroup(ObservableList<ClassEmployee> group){
        this.selectedGroup = group;
    }

    @FXML
    private void changeGroupData(ActionEvent event){
        try {
            String newGroupName = newGroupNameTextField.getText();
            int newGroupCapacity = Integer.parseInt(newGroupCapacityTextField.getText());

            if (newGroupCapacity < selectedGroup.get(0).getGroupOfEmployees().size()) {
                throw new InputMismatchException("New capacity can't be smaller than actual group size");
            }

            selectedGroup.get(0).setGroupName(newGroupName);
            selectedGroup.get(0).setMaxEmployees(newGroupCapacity);

            switchToManageGroups(event);
        }catch (InputMismatchException e){
            createAlert(e.getMessage());
        }catch (Exception e){
            createAlert("You has provided invalid data");
        }

        newGroupNameTextField.clear();
        newGroupCapacityTextField.clear();
    }

    @FXML
    private void addEmployeeToGroup(ActionEvent event){
        try{
            ObservableList<Employee> singleEmployee;
            singleEmployee = employeesTable.getSelectionModel().getSelectedItems();

            selectedGroup.get(0).addEmployee(singleEmployee.get(0));

            switchToManageGroups(event);
        } catch (InputMismatchException e){
            createAlert(e.getMessage());
        } catch (Exception e){
            createAlert("You can add an employee only from table of all employees");
        }
    }

    @FXML
    private void deleteEmployeeFromGroup(ActionEvent event) throws IOException {
        try{
            ObservableList<Employee> selectedEmployee;
            selectedEmployee = groupTable.getSelectionModel().getSelectedItems();
            selectedGroup.get(0).removeEmployee(selectedEmployee.get(0));

            switchToManageGroups(event);
        } catch (Exception e){
            createAlert("You can delete an employee only from table of employees from the group");
        }

    }
}
