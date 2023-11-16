package project.control.manageEmployees;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.model.Employee;
import project.model.EmployeeCondition;
import java.net.URL;
import java.util.InputMismatchException;
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

        try{
            String firstName = textFieldFirstName.getText();
            String lastName = textFieldLastName.getText();
            EmployeeCondition condition = choiceBoxCondition.getValue();
            int yearOfBirth = Integer.parseInt(textFieldYearOfBirth.getText());
            double salary = Double.parseDouble(textFieldSalary.getText());

            //Checking if name contains only letters
            if(!firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+")){
                throw new InputMismatchException("Names can only contain letters");
            }



            Employee potentialEmployee = new Employee(firstName, lastName, condition, yearOfBirth, salary);

            boolean employeeAlreadyExists = false;
            for (Employee employee : employeesList) {
                if(potentialEmployee.getFirstName().equals(employee.getFirstName()) && potentialEmployee.getLastName().equals(employee.getLastName())){
                    employeeAlreadyExists = true;
                    break;
                }
            }

            if(employeeAlreadyExists){
                createAlert("Such an employee already exists");
            } else {
                employeesList.add(potentialEmployee);
            }

        } catch(InputMismatchException e) {
            createAlert(e.getMessage());
        } catch (Exception e) {
            createAlert("You has provided invalid data");
        }



        textFieldFirstName.clear();
        textFieldLastName.clear();
        textFieldSalary.clear();
        textFieldYearOfBirth.clear();

    }

}
