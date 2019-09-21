package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * /** Production Line Tracker Project used with a database to help with organizing
 * products. @Author Nickolas Gadomski
 */
public class Main extends Application {

  /**
   * Sets title for project and sets stage.
   *
   * @param primaryStage sets stage
   * @throws Exception throws the exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root =
        FXMLLoader.load(
            getClass()
                .getResource("sample.fxml")); // Error with FXML file check FXML add to controller
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(new Scene(root, 600, 400));
    primaryStage.show();
  }

  /**
   * Helps with launching program.
   *
   * @param args standard parameter
   */
  public static void main(String[] args) {
    launch(args);
  }
}
