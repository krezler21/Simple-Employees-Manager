package project.control.manageEmployees;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import project.model.Employee;
import project.model.EmployeeCondition;
import java.net.URL;
import java.util.ResourceBundle;

public class AddEmployeeController extends ManageEmployeesController implements Initializable {

    @FXML
    private TextField textFieldFirstName;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private ChoiceBox<EmployeeCondition> choiceBoxCondition;
    private final EmployeeCondition[] employeeConditions = {EmployeeCondition.PRESENT, EmployeeCondition.ABSENT,
        EmployeeCondition.DURING_DELEGATION, EmployeeCondition.SICK};

    @FXML
    private TextField textFieldSalary;

    @FXML
    private TextField textFieldYearOfBirth;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxCondition.setValue(EmployeeCondition.PRESENT);
        choiceBoxCondition.getItems().addAll(employeeConditions);
        super.initialize(url, resourceBundle);
    }

    @FXML
    private void addEmployeeToList(ActionEvent event) {
        employeesList.add(new Employee(textFieldFirstName.getText(), textFieldLastName.getText(), choiceBoxCondition.getValue(),
                Integer.parseInt(textFieldYearOfBirth.getText()), Double.parseDouble(textFieldSalary.getText())));

        textFieldFirstName.clear();
        textFieldLastName.clear();
        textFieldSalary.clear();
        textFieldYearOfBirth.clear();

    }

}
