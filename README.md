# Simple-Employee-Manager
This application provides a user-friendly interface for managing employee information within a company.

## Motivation and Project Description
I created this application as a coursework project for the "Windowed and Mobile Applications" course. This allowed me to become more familiar with JavaFX and Java itself. The application facilitates the management of employees within a company. From the main menu, users can navigate to two subsequent windows: "Manage Employees" or "Manage Groups."

"Manage Employees" is a list of all employees in the company. It enables the addition, removal, and modification of employee data. Furthermore, there is an option to search the entire list of employees based on a fragment of their first name or last name.

"Manage Groups" is a list of all groups within the company. It allows for the creation, deletion, and editing of group data. While editing a group, users can add employees to the group from the list of all employees.

The application includes safeguards against actions such as adding the same employee to a group or entering incorrect data. In case of mishandling the program, an alert should appear, providing information on what steps need to be taken to complete a specific action.

## Installation
If you would like to install my project I highly recommend you to do this via IntellIJ. Threre are few steps how to do this:
* Create new "JavaFX" project in IntellIJ
* Replace your "main" folder with my "main" folder, downloaded from this repository
* Copy code below into "pom.xml" file
```XML
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>hellofxml</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <javafx.version>21</javafx.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-graphics</artifactId>
            <version>${javafx.version}</version>
        </dependency>

        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>${javafx.version}</version>
        </dependency>

        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>${javafx.version}</version>
        </dependency>
    </dependencies>

</project>
```

## Summary
The implementation of the project allowed me to familiarize myself primarily with JavaFX. It appears to be a highly useful tool for creating windowed applications. I plan to further expand the program by adding additional functionalities, such as enabling the addition of ratings and comments to groups, as well as enhancing the application by incorporating database utilization and Hibernate technology.
