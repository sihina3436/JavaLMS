package org.example.javalms;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AdminController {

    @FXML
    private JFXButton adminCoursebtn;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Label adminDatelable;

    @FXML
    private JFXButton adminHomebtn;

    @FXML
    private JFXButton adminLogoutbtn;

    @FXML
    private JFXButton adminNoticebtn;

    @FXML
    private Label adminTimelable;

    @FXML
    private JFXButton adminTimetablebnt;

    @FXML
    private JFXButton adminUserbtn;

    @FXML
    private Label adminWelcomeLable;

    @FXML
    public void adminHomeClick(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("adminHome.fxml"));
        borderPane.setCenter(view);

    }
    @FXML
    public void adminUserClick(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("adminUser.fxml"));
        borderPane.setCenter(view);

    }

    @FXML
    public void adminNoticeClick(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("adminNotice.fxml"));
        borderPane.setCenter(view);
    }

    @FXML
    public void adminCourseClick(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("adminCourse.fxml"));
        borderPane.setCenter(view);
    }
    @FXML
    public void adminTimetableClick(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("adminTimetable.fxml"));
        borderPane.setCenter(view);

    }
    @FXML
    public void adminLogoutClick(ActionEvent event){
        try {
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene scene = new Scene(loader.load(), 600, 400);
            Stage stage = (Stage) adminLogoutbtn.getScene().getWindow();
            stage.close();
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
