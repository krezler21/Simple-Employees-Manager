module project.employeemanager {
    requires  javafx.graphics;
    requires  javafx.fxml;
    requires  javafx.controls;

    exports project.main to javafx.graphics;
    opens project.model to javafx.base;
    opens project.control to javafx.fxml;
    opens project.control.manageEmployees to javafx.fxml;
    opens project.control.manageGroups to javafx.fxml;
}
