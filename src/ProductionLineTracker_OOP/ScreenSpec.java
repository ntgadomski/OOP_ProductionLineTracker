package ProductionLineTracker_OOP;

/**
 * Interface implemented by other classes for media methods
 * @Author: Nickolas Gadomski
 */
public interface ScreenSpec {
    public String getResolution();
    public int getRefreshRate();
    public int getResponseTime();

}
