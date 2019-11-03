package productionlinetracker;

/** Interface implemented by other classes for product methods @Author: Nickolas Gadomski */
public interface Item {
  int getId();

  void setName(String name);

  String getName();

  void setManufacturer(String manufacturer);

  String getManufacturer();
}
