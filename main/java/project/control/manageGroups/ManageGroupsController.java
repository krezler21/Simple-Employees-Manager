package project.control.manageGroups;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.control.Controller;
import project.model.ClassEmployee;
import project.model.Employee;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManageGroupsController extends Controller implements Initializable {

    @FXML
    protected ListView<ClassEmployee> groupsListView;

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
    protected void removeGroup(ActionEvent event) throws IOException {
        ObservableList<ClassEmployee> allGroups, singleGroup;
        allGroups = groupsListView.getItems();
        singleGroup =groupsListView.getSelectionModel().getSelectedItems();
        singleGroup.forEach(allGroups::remove);

        switchToManageGroups(event);
    }

    @FXML
    protected void switchToAddGroup(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/manageGroups/addGroup.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToShowData(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/manageGroups/showData.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
