package ProductionLineTracker_OOP;
/**
 * Audio player is a subclass of product class that gives detail for audio player type products.
 * Also utilizes media control class @Author: Nickolas Gadomski
 */
public class AudioPlayer extends Product implements MultimediaControl {
  private String audioSpecification;
  private String mediaType;

  /**
   * Constructor that creates audio player product with given parameters
   *
   * @param name String product name
   * @param manufacturer  String product company
   * @param audioSpecification local String audio spec. field
   * @param mediaType local String media type field
   */
  public AudioPlayer(
      String name, String manufacturer, String audioSpecification, String mediaType) {
    super(name, manufacturer, ItemType.AUDIO);
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  /**
   * Accessor for local audio spec. field
   *
   * @return String audioSpecification
   */
  public String getAudioSpecification() {
    return this.audioSpecification;
  }

  /**
   * Mutator sets local audio spec. field
   *
   * @param audioSpecification String audioSpecification.
   */
  public void setAudioSpecification(String audioSpecification) {
    this.audioSpecification = audioSpecification;
  }

  /**
   * Accessor for local media type field
   *
   * @return String mediaType
   */
  public String getMediaType() {
    return this.mediaType;
  }

  /**
   * Mutator sets local media type field
   *
   * @param mediaType String mediaType
   */
  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  /** Media controller method for play */
  public void play() {
    System.out.println("Playing");
  }

  /** Media controller method for stop */
  public void stop() {
    System.out.println("Stopping");
  }

  /** Media controller method for previous */
  public void previous() {
    System.out.println("Previous");
  }

  /** Media controller method for next */
  public void next() {
    System.out.println("Next");
  }

  /**
   * Format String method
   *
   * @return the formatted String
   */
  public String toString() {
    return String.format(
        "%s\nSupported Audio Formats: %s\nSupported Playlist Formats: %s",
        super.toString(), this.audioSpecification, this.mediaType);
  }
}
