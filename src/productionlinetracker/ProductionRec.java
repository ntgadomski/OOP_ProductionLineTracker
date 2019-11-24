package productionlinetracker;

import java.util.Date;


/**
 * Production record class used to store updated data into the database @Author: Nickolas Gadomski.
 */
public class ProductionRec {

  private int productionNum;
  private int productID;
  private String serialNum;
  private Date produceDate;
 private String productName;


  /**
   * Constructor to create product identification.
   *
   * @param productID local integer productID.
   */
  public ProductionRec(int productID) {
    this.productID = productID;
    this.productionNum = 0;
    this.serialNum = "0";
    this.produceDate = new Date();

  }

  /**
   * Constructor to record product fields.
   *
   * @param productionNum local integer production number.
   * @param productName local String product name.
   * @param serialNum local String serial number.
   * @param produceDate local Date produced Date.
   */
  public ProductionRec(int productionNum, String productName, String serialNum, Date produceDate) {
    this.productName = productName;
    this.productionNum = productionNum;
    this.serialNum = serialNum;
    this.produceDate = produceDate;

  }

  /**
   * Constructor to print output of product fields.
   *
   * @param product local Product product field.
   * @param counter local integer counter field.
   */
  public ProductionRec(Product product, int counter) {

    this.produceDate = new Date();
    this.serialNum = product.getManufacturer().substring(0, 3) + product.getType().getItem() + String.format("%05d", counter);
    this.productName = product.getProdName();

   // this.p = product;
  }

  /**
   * Accessor for local ProduceDate field.
   * @return Date produceDate
   */
  public Date getProduceDate() { return produceDate; }

  /**
   * Accessor for local productName field.
   * @return String productName
   */
  public String getProductName(){return productName;}

  /**
   * Accessor for local production number field.
   *
   * @return String productionNum.
   */
  public int getProductionNum() {
    return productionNum;
  }

  /**
   * Mutator sets local production number field.
   *
   * @param productionNum integer ProductionNum.
   */
  public void setProductionNum(int productionNum) {
    this.productionNum = productionNum;
  }

  /**
   * Accessor for local productID field.
   *
   * @return integer productID
   */
  public int getProductID() {
    return productID;
  }

  /**
   * Mutator sets local Product ID field.
   *
   * @param productID integer product ID
   */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * Accessor for local serial number field.
   *
   * @return String serialNum
   */
  public String getSerialNum() {
    return serialNum;
  }

  /**
   * Mutator sets local serial number field.
   *
   * @param serialNum String serialNum
   */
  public void setSerialNum(String serialNum) {
    this.serialNum = serialNum;
  }

  // public Date getProdDate() {
  // return produceDate;
  // }

  // public void setProdDate(Date produceDate) {
  // this.produceDate = produceDate;
  // }

  /**
   * Format String method.
   *
   * @return the formatted String
   */
  public String toString() {

    return String.format(
        "Prod. Num: %s Product Name: %s Serial Num: %s Date: %s",
        productionNum, productName, serialNum, produceDate);
  }
}
