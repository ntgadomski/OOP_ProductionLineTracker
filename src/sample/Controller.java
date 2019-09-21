package sample;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import org.w3c.dom.ls.LSOutput;

/** Controller Class Handles the the outputs of buttons. */
public class Controller {

  @FXML private ComboBox<Integer> comboBox;

  /** add product button on production line tab. */
  @FXML private Button addProduct;

  /** record button on produce tab. */
  @FXML private Button record;

  /**
   *  Handles action when button is clicked Outputs to console.
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
  void list(MouseEvent event) {}

  /** Method to start the comboBox. */
  @FXML
  public void initialize() {
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
