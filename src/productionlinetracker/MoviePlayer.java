package productionlinetracker;

/**
 * Movie player is a subclass of product class that gives detail for movie player type products.
 * Also utilizes media control class @Author Nickolas Gadomski
 */
public class MoviePlayer extends Product implements MultimediaControl {

  /**
   * Constructor that creates audio player product with given parameters.
   *
   * @param name product name
   * @param manufacturer product company
   * @param screen local screen field
   * @param monitorType local monitor type field
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
  }

  /** Media controller method for play movie. */
  public void play() {
    System.out.println("Playing movie");
  }

  /** Media controller method for stop movie. */
  public void stop() {
    System.out.println("Stopping movie");
  }

  /** Media controller method for previous movie. */
  public void previous() {
    System.out.println("Previous movie");
  }

  /** Media controller method for next movie. */
  public void next() {
    System.out.println("Next movie");
  }

  /*
  @Override
  public String toString() {
    return String.format("%n Screen: %n MonitorType: %n", super.toString(), screen, monitorType);
  }

   */
}
