package productionLineTracker_OOP;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



// import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
// import javafx.event.ActionEvent;
// import org.w3c.dom.ls.LSOutput;
//
/**
 * Controller Class Handles the the outputs of buttons and connects database. @Author: Nickolas
 * Gadomski
 */
public class ProductionLine_controller {

  private static final String jdbc_driver = "org.h2.Driver";
  private static final String DB_url = "jdbc:h2:./res/Products";

  private static final String user = "";
  private static final String pass = "";

  private Connection conn = null;

  private Statement stmt = null;

  /** Method that starts the connection between the controller and the database. */
  public void connDatabase() {
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

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }



  /** List of FX identities used for functionality. */
  @FXML private ComboBox<Integer> cbShowProd;

  @FXML private ChoiceBox<String> choiceAddProduct;

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

  /**
   * Method used for choice box functionality.
   *
   * @param event MouseEvent Object
   */
  @FXML
  void choice(MouseEvent event) {
    //
  }

  /**
   * Method used for the Add Product button.
   *
   * @param event MouseEvent Object
   */
  @FXML
  void addProduct(MouseEvent event) {
    //productList.add(new Widget(tf_productName, tf_manufacturer, ));
    lvChooseProduct.getItems().add(String.valueOf(productList));
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

  ObservableList<Product> productList;

  /** Method to start functionality. */
  @FXML
  public void initialized() {
    cbShowProd.setEditable(true);
    cbShowProd.getItems().add(1);
    cbShowProd.getItems().add(2);
    cbShowProd.getItems().add(3);
    cbShowProd.getItems().add(4);
    cbShowProd.getItems().add(5);
    cbShowProd.getItems().add(6);
    cbShowProd.getItems().add(7);
    cbShowProd.getItems().add(8);
    cbShowProd.getItems().add(9);
    cbShowProd.getItems().add(10);
    cbShowProd.getSelectionModel().selectFirst();

    for (ItemType itemFL : ItemType.values()) {
      choiceAddProduct.getItems().add(itemFL + "" + itemFL.item);
    }

    ObservableList<Product> prods = FXCollections.observableArrayList();
    clProdName.setCellValueFactory(new PropertyValueFactory("name"));
    clProdMan.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    clProdType.setCellValueFactory(new PropertyValueFactory("type"));
    tvProducts.setItems(prods);
    prods.add(new Product("pod", "Apple", ItemType.AUDIO) {});
    lvChooseProduct.getItems().add(prods);

    //    ArrayList<Bike> bikesAL = new ArrayList<>();
    //    ObservableList<Bike> bikes = FXCollections.observableArrayList();
    //
    //    numGearsCol.setCellValueFactory(new PropertyValueFactory("numGears"));
    //
    //    bikeTable.setItems(bikes);
    //
    //    bikes.add(new Bike(12));

  }
}
