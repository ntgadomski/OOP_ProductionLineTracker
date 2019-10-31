package ProductionLineTracker_OOP;

/**
 * Screen class implements ScreenSpec class fields to create a screen
 * @Author: Nickolas Gadomski
 */
public class Screen implements ScreenSpec {
    private String resolution;
    private int refreshRate;
    private int responseTime;

    /**
     * Constructor creates screen using local variables as parameters
     * @param resolution String resolution
     * @param refreshRate integer refreshRate
     * @param responseTme integer responseTime
     */
    public Screen(String resolution, int refreshRate, int responseTme){
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.responseTime = responseTime;
    }

    /**
     * Accessor for local resolution field
     * @return String resolution
     */
    public String getResolution(){
        return resolution;
    }

    /**
     * Accessor for local refresh rate field
     * @return integer refreshRate
     */
    public int getRefreshRate(){
        return refreshRate;
    }

    /**
     * Accessor for local response time field
     * @return integer responseTime
     */
    public int getResponseTime(){
        return responseTime;
    }

    /**
     * Format String method
     *
     * @return the formatted String
     */
    public String toString(){
        String str = String.format("\nResolution: %s\nRefresh Rate: %s\nResponse Time: %s",
                resolution, refreshRate, responseTime);
        return str;
    }
}
