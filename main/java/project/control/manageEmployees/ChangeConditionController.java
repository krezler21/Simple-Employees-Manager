package project.control.manageEmployees;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import project.model.Employee;
import project.model.EmployeeCondition;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangeConditionController extends ManageEmployeesController{
    @FXML
    private ChoiceBox<EmployeeCondition> choiceBoxCondition;
    private final EmployeeCondition[] employeeConditions = {EmployeeCondition.PRESENT, EmployeeCondition.ABSENT,
            EmployeeCondition.DURING_DELEGATION, EmployeeCondition.SICK};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxCondition.setValue(EmployeeCondition.PRESENT);
        choiceBoxCondition.getItems().addAll(employeeConditions);
        super.initialize(url, resourceBundle);
    }

    public void changeSelectedEmployeeCondition(ActionEvent event) throws IOException {
        ObservableList<Employee> temporaryEmployeesList;
        temporaryEmployeesList = employeesTable.getSelectionModel().getSelectedItems();
        temporaryEmployeesList.get(0).setCondition(choiceBoxCondition.getValue());

        //Switch po to, aby odświeżyć wyświetlaną tablicę
        switchToChangeCondition(event);
    }


}
