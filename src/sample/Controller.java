package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
// import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
// import javafx.event.ActionEvent;
// import org.w3c.dom.ls.LSOutput;

/** Controller Class Handles the the outputs of buttons and connects database. */
public class Controller {

  private static final String jdbc_driver = "org.h2.Driver";
  private static final String DB_url = "jdbc:h2:./res/Products";

  private static final String user = "";
  private static final String pass = "";
  private Connection conn = null;
  private Statement stmt = null;

  /** Method that starts the connection between the controller and the database. */
  public void initialize() {
    try {
      Class.forName(jdbc_driver);
      conn = DriverManager.getConnection(DB_url, user, pass);
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
  }

  @FXML private ComboBox<Integer> comboBox;

  /** add product button on production line tab. */
  @FXML private Button addProduct;

  /** record button on produce tab. */
  @FXML private Button record;

  /**
   * Handles action when button is clicked Outputs to console.
   *
   * @param event MouseEvent Object
   */
  @FXML
  void printOutput(MouseEvent event) {

    System.out.println("Product Added");
  }

  /**
   * Handles action when button is clicked Outputs to console.
   *
   * @param event MouseEvent object
   */
  @FXML
  void record(MouseEvent event) {
    System.out.println("Recorded");
  }

  /**
   * Handles action when comboBox is clicked.
   *
   * @param event MouseEvent object
   */
  @FXML
  void list(MouseEvent event) {
    //
  }

  /** Method to start the comboBox. */
  @FXML
  public void combo() {
    comboBox.setEditable(true);
    comboBox.getItems().add(1);
    comboBox.getItems().add(2);
    comboBox.getItems().add(3);
    comboBox.getItems().add(4);
    comboBox.getItems().add(5);
    comboBox.getItems().add(6);
    comboBox.getItems().add(7);
    comboBox.getItems().add(8);
    comboBox.getItems().add(9);
    comboBox.getItems().add(10);
    comboBox.getSelectionModel().selectFirst();
  }
}
