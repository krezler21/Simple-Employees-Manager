package project.control.manageGroups;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import project.model.ClassEmployee;

public class AddGroupController extends ManageGroupsController {

    @FXML
    private TextField groupNameTextField;

    @FXML
    private TextField groupCapacityTextField;

    @FXML
    private void addGroupToList(ActionEvent event){
        try{
            String groupName = groupNameTextField.getText();
            int capacity = Integer.parseInt(groupCapacityTextField.getText());

            if(capacity <= 0){
                throw new Exception();
            }

            ClassEmployee potentialGroup = new ClassEmployee(groupName, capacity);

            boolean groupAlreadyExists = false;
            for (ClassEmployee group : groupsList) {
                if(group.getGroupName().equalsIgnoreCase(potentialGroup.getGroupName())){
                    groupAlreadyExists = true;
                    break;
                }
            }

            if(groupAlreadyExists){
                createAlert("This group already exists");
            } else {
                groupsList.add(potentialGroup);
            }


        } catch (Exception e){
            createAlert("You has provided invalid data");
        }
        groupNameTextField.clear();
        groupCapacityTextField.clear();
    }


}
