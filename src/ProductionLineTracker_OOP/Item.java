package ProductionLineTracker_OOP;

/**
 * Interface implemented by other classes for product methods
 * @Author: Nickolas Gadomski
 */
public interface Item {
    public int getId();
    public void setName(String name);
    public String getName();
    public void setManufacturer(String manufacturer);
    public String getManufacturer();
}
