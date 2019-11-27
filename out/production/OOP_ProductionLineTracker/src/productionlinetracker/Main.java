package productionlinetracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;

import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

/**
 * /** Production Line Tracker Project used with a database to help with organizing
 * products. @Author: Nickolas Gadomski
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
                .getResource(
                    "ProductionLine.fxml")); // Error with FXML file check FXML add to controller
    primaryStage.setTitle("Production Line Tracker");

    Scene scene = new Scene(root, 650, 400);
    scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

    //    primaryStage.setScene(new Scene(root, 600, 400));

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Helps with launching program. And used to test program variables and classes
   *
   * @param args standard parameter
   */
  public static void main(
      String[] args) { // Driver not found go into project structure and find H2 Driver

    launch(args);
  }

}
