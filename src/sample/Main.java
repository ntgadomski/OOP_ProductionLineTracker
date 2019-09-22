package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/HR";

    final String USER = "";
    final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      System.out.println("Database Connection Established.");

      /*
      String sql = "SELECT * FROM JOBS";

      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        System.out.println(rs.getString(1));
      }

       */
      stmt.close();
      conn.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    launch(args);
  }
}
