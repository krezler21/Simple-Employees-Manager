package project.control.manageEmployees;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import project.model.Employee;
import project.model.EmployeeCondition;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditEmployeeController extends ManageEmployeesController{
    @FXML
    private ChoiceBox<EmployeeCondition> choiceBoxCondition;
    private final EmployeeCondition[] employeeConditions = {EmployeeCondition.PRESENT, EmployeeCondition.ABSENT,
            EmployeeCondition.DURING_DELEGATION, EmployeeCondition.SICK};

    @FXML
    private TextField modifiedSalary;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxCondition.setValue(EmployeeCondition.PRESENT);
        choiceBoxCondition.getItems().addAll(employeeConditions);
        super.initialize(url, resourceBundle);
    }

    public void changeSelectedEmployeeCondition(ActionEvent event) throws IOException {
        try {
            ObservableList<Employee> temporaryEmployeesList;
            temporaryEmployeesList = employeesTable.getSelectionModel().getSelectedItems();

            EmployeeCondition newCondition = choiceBoxCondition.getValue();
            double newSalary = Double.parseDouble(modifiedSalary.getText());

            temporaryEmployeesList.get(0).setCondition(newCondition);
            temporaryEmployeesList.get(0).setSalary(newSalary);
        } catch (Exception e) {
            createAlert("Salary can contain only numbers");
        }


        //Switch po to, aby odświeżyć wyświetlaną tablicę
        switchToChangeCondition(event);
    }


}
