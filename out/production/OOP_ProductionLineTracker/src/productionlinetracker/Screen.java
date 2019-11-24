package productionlinetracker;

/** Screen class implements ScreenSpec class to create a screen. @Author: Nickolas Gadomski */
public class Screen implements ScreenSpec {
  private final String resolution;
  private final int refreshRate;
  private int responseTime;

  /**
   * Constructor creates screen using local variables as parameters.
   *
   * @param resolution String resolution
   * @param refreshRate integer refreshRate
   * @param responseTme integer responseTime
   */
  public Screen(String resolution, int refreshRate, int responseTme) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    // this.responseTime = responseTime;
  }

  /**
   * Accessor for local resolution field.
   *
   * @return String resolution
   */
  public String getResolution() {
    return resolution;
  }

  /**
   * Accessor for local refresh rate field.
   *
   * @return integer refreshRate
   */
  public int getRefreshRate() {
    return refreshRate;
  }

  /**
   * Accessor for local response time field.
   *
   * @return integer responseTime
   */
  public int getResponseTime() {
    return responseTime;
  }

  /*
  public String toString() {
    return String.format(
        "%n Resolution: %n Refresh Rate: %n Response Time: %n",
        resolution, refreshRate, responseTime);
  }

   */
}
