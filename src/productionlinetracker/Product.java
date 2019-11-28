package productionlinetracker;

/**
 * Abstract product class created to be super class for product subclasses. Also utilizes Item
 * Interface (cannot be instantiated as abstract). @Author: Nickolas Gadomski
 */
public abstract class Product implements Item {
  private int id;
  private String prodName;
  private String manufacturer;
  private ItemType type;

  /**
   * Constructor for local product fields.
   *
   * @param prodName product name
   * @param manufacturer product company
   * @param type product type
   */
  Product(String prodName, String manufacturer, ItemType type) {
    this.prodName = prodName;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  /**
   * Accessor for local id field.
   *
   * @return integer id
   */
  public int getId() {
    return id;
  }

  /**
   * Mutator sets local id field.
   *
   * @param id integer id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Accessor for local name field.
   *
   * @return String name
   */
  public String getProdName() {
    return prodName;
  }

  /**
   * Mutator sets local name field.
   *
   * @param prodName String name
   */
  public void setProdName(String prodName) {
    this.prodName = prodName;
  }

  /**
   * Accessor for local manufacturer field.
   *
   * @return String manufacturer
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Mutator sets local manufacturer field.
   *
   * @param manufacturer String manufacturer
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * Accessor for local type field.
   *
   * @return Enum ItemType type
   */
  public ItemType getType() {
    return type;
  }

  /**
   * Mutator sets local type field.
   *
   * @param type Enum ItemType type
   */
  public void setType(ItemType type) {
    this.type = type;
  }

  /**
   * Format String method.
   *
   * @return the formatted String
   */
  public String toString() {
    return "Name: " + prodName + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + type;
  }
}
