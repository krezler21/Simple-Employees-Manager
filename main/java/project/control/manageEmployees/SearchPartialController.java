package project.control.manageEmployees;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import project.model.Employee;

public class SearchPartialController extends ManageEmployeesController{

    @FXML
    private TextField textFieldSearchPartial;
    public void searchPartial(ActionEvent event){
        ObservableList<Employee> temporaryList =  FXCollections.observableArrayList();

        for (Employee employee : employeesList) {
            if(employee.getFirstName().toUpperCase().contains(textFieldSearchPartial.getText().toUpperCase())
                    || employee.getLastName().toUpperCase().contains(textFieldSearchPartial.getText().toUpperCase())){

                temporaryList.add(employee);

            }
        }

        employeesTable.setItems(temporaryList);
    }
}
