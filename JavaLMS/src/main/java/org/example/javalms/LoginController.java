package org.example.javalms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController extends DatabaseConnection{

    @FXML
    private Button loginButton;
    @FXML
    private Label templable;

    @FXML
    private Button cancelButton;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    public void LoginEvent(ActionEvent event){
        DatabaseConnection ConnectDB = new DatabaseConnection();
        Connection connection = ConnectDB.getConnection();
//        templable.setText("Sihina");

        String selectQuery = "SELECT Password,status FROM user WHERE First_name = ?";

        try{
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            statement.setString(1,usernameTextField.getText());

            ResultSet queryOutput = statement.executeQuery();
            String EnteredPassword = passwordTextField.getText();

            if(queryOutput.next()){
                String UserPassword = queryOutput.getString("Password");
                String UserStatus = queryOutput.getString("status");
                if(EnteredPassword.equals(UserPassword) && UserStatus.equals("admin")){
                    System.out.println("ok");
                    OpenAdminpanel();
                } else if (EnteredPassword.equals(UserPassword) && UserStatus.equals("student")) {
                    OpenStudentPanel();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void OpenAdminpanel(){
        try{
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
            Scene scene = new Scene(loader.load(), 800, 500);
//          primaryStage.setTitle("Student Scene");
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private void OpenStudentPanel(){
        try{
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
            Scene scene = new Scene(loader.load(), 800, 500);
//          primaryStage.setTitle("Student Scene");
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    @FXML
    public void CancelEvent(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}
