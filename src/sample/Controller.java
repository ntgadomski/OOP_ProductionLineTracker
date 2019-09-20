package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/** Controller Class Handles the the outputs of buttons. */
public class Controller {

  /** add product button on production line tab. */
  @FXML private Button addProduct;

  /** record button on produce tab. */
  @FXML private Button record;

  /**
   * Handles action when button is clicked Outputs to console.
   *
   * @param event ActionEvent Object
   */
  @FXML
  void printOutput(ActionEvent event) {
    System.out.println("Product Added");
  }

  /**
   * Handles action when button is clicked Outputs to console.
   *
   * @param event ActionEvent object
   */
  @FXML
  void display(ActionEvent event) {
    System.out.println("Recorded");
  }
}
