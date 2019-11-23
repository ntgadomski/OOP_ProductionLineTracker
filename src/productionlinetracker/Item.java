package productionlinetracker;

/** Interface implemented by other classes for product methods. @Author: Nickolas Gadomski */
public interface Item {
  int getId();

  void setProdName(String prodName);

  String getProdName();

  void setManufacturer(String manufacturer);

  String getManufacturer();
}
