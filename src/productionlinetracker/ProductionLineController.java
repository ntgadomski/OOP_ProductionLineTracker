package productionlinetracker;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
  static Statement stmt = null;
  static Connection conn = null;
//  static PreparedStatement preparedStatement;

  /** Method that starts the connection between the controller and the database. */
  public void initializeDB() {
    final String jdbc_driver = "org.h2.Driver";
    final String db_url = "jdbc:h2:./res/Products";

    final String user = "";
    String pass = "";

    try{
      Properties prop = new Properties();
      prop.load(new FileInputStream("res/properties"));
      pass = prop.getProperty("password");
    } catch (Exception e){
      System.out.println("Error with database password.");
    }

    System.out.println("Attempting to connect to database.");
    try {
      Class.forName(jdbc_driver);
      conn = DriverManager.getConnection(db_url, user, pass);
      stmt = conn.createStatement();
      System.out.println("Database connection established.");

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
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

  private ObservableList<Product> prods;
  private int prodsIndex = 0;


  /**
   * Method used for the Add Product button.
   *
   * @param event MouseEvent Object
   */
  @FXML
  void addProduct(MouseEvent event) throws SQLException {
    lvChooseProduct.getItems().clear();
    String prodName = tfProductName.getText();
    String manufacturer = tfManufacturer.getText();
    ItemType type = choiceAddProduct.getValue();

    String productQuery = "INSERT INTO PRODUCT(NAME, TYPE, MANUFACTURER) VALUES (?,?,?)";

      PreparedStatement addProduct = conn.prepareStatement(productQuery);
      addProduct.setString(1, prodName);
      addProduct.setString(2, type.toString());
      addProduct.setString(3, manufacturer);
      addProduct.executeUpdate();

    tfProductName.clear();
    tfManufacturer.clear();
    choiceAddProduct.getSelectionModel().clearSelection();

    prods.add(new Widget(prodName, manufacturer, type));
    lvChooseProduct.getItems().addAll(prods);

    System.out.println("Product Added");
  }

  /**
   * Handles action when button is clicked Outputs to console.
   *
   * @param event MouseEvent object
   */
  @FXML
  void record(MouseEvent event) {
    loadProductionLog();
    System.out.println("Product Recorded");
  }

  /** Method to start functionality. */
  @FXML
  public void initialize() throws SQLException {
    cbShowProd.setEditable(true);
    cbShowProd.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    cbShowProd.getSelectionModel().selectFirst();

    for (ItemType item : ItemType.values()) {
      choiceAddProduct.getItems().add(item);
    }

    prods = FXCollections.observableArrayList();

    initializeDB();
    loadProductList();
    setUpProductLineTable();
    showProduction();
    addToProductionDB();
  }

  public void loadProductList() throws SQLException {
  String sql = "SELECT * FROM PRODUCT";
  ResultSet rs = stmt.executeQuery(sql);
  while (rs.next()){
    // corresponds to database table columns
    String nameDB = rs.getString(2);
    ItemType typeDB = ItemType.valueOf(rs.getString(3));
    String manDB = rs.getString(4);
    // create object
    Product productDB = new Widget(nameDB, manDB, typeDB);
    // save to observable list
    prods.add(productDB);
    lvChooseProduct.getItems().add(prods.get(prodsIndex++));
  }
  }

  public void showProduction() throws SQLException {
//    String sql = "SELECT * FROM PRODUCTIONRECORD";
//    ResultSet rs = stmt.executeQuery(sql);
//    while (rs.next()){
//      // corresponds to database table columns
//      String prodNumDB = rs.getString(2);
//      String prodNameDB = rs.getString(rs.getString(3));
//      String serialNumDB = rs.getString(4);
//
//      // create object
//      Product productDB = new Widget(nameDB, manDB, typeDB);
//      // save to observable list
//      prods.add(productDB);
//      lvChooseProduct.getItems().add(prods.get(prodsIndex++));

  }

  public void addToProductionDB(){

  }


  public void loadProductionLog(){
    int itemCount = 1;
    String quantityS = String.valueOf(cbShowProd.getValue());
    int numberProd = Integer.parseInt(quantityS);
    for (int runProd = 1; runProd <= numberProd; runProd++) {
      ProductionRec recProd = new ProductionRec(itemCount++);

      taProdLog.appendText((recProd.toString() + "\n"));

    }
  }

  public void setUpProductLineTable(){
    clProdName.setCellValueFactory(new PropertyValueFactory("prodName"));
    clProdMan.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    clProdType.setCellValueFactory(new PropertyValueFactory("type"));
    tvProducts.setItems(prods);
  }
}


