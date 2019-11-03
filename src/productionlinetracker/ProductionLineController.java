package productionlinetracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import javafx.scene.control.ListView;

import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * Controller Class Handles the the outputs of buttons and connects database. @Author: Nickolas
 * Gadomski
 */
public class ProductionLineController {

  private String jdbcDriver = "org.h2.Driver";
  private String dbUrl = "jdbc:h2:./res/Products";

  private String user = "";
  private String pass = "";

  private Connection conn = null;

  private Statement stmt = null;

  /** Method that starts the connection between the controller and the database. */
  public void connDatabase() {
    try {
      Class.forName(jdbcDriver);
      conn = DriverManager.getConnection(dbUrl, user, pass);
      stmt = conn.createStatement();
      System.out.println("Database Connection Established.");

      /*
      String sql = "SELECT * FROM JOBS";

      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        System.out.println(rs.getString(1));
      }

       */
      //      stmt.close();
      //      conn.close();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  /** List of FX identities used for functionality. */
  @FXML private ComboBox<Integer> cbShowProd;

  @FXML private ChoiceBox<ItemType> choiceAddProduct;

  @FXML private TextField tfProductName;

  @FXML private TextField tfManufacturer;

  @FXML private TableView<Product> tvProducts;

  @FXML private TableColumn<?, ?> clProdName;

  @FXML private TableColumn<?, ?> clProdMan;

  @FXML private TableColumn<?, ?> clProdType;

  @FXML private ListView lvChooseProduct;

  @FXML private TextArea taProdLog;

  /** add product button on production line tab. */
  @FXML private Button btnAddProduct;

  /** record button on produce tab. */
  @FXML private Button btnRecord;

  ObservableList<Product> prods;

  /**
   * Method used for choice box functionality.
   *
   * @param actionEvent MouseEvent Object
   */
  public void choice(ActionEvent actionEvent) {
    //
  }

  /**
   * Method used for the Add Product button.
   *
   * @param event MouseEvent Object
   */
  @FXML
  void addProduct(MouseEvent event) {

    String name = tfProductName.getText();
    String manufacturer = tfManufacturer.getText();
    ItemType type = choiceAddProduct.getValue();

    prods.add(new Widget(name, manufacturer, type));
    lvChooseProduct.getItems().add(String.valueOf(prods));
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

  /** Method to start functionality. */
  @FXML
  public void initialized() {
    cbShowProd.setEditable(true);
    cbShowProd.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    cbShowProd.getSelectionModel().selectFirst();

    for (ItemType itemFL : ItemType.values()) {
      choiceAddProduct.getItems().add(itemFL);
    }

    prods = FXCollections.observableArrayList();
    clProdName.setCellValueFactory(new PropertyValueFactory("name"));
    clProdMan.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    clProdType.setCellValueFactory(new PropertyValueFactory("type"));
    tvProducts.setItems(prods);
  }
}
