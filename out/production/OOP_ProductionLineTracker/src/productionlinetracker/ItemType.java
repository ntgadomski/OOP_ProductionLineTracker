package productionlinetracker;

/** Enumeration list of variables for different product types. @Author: Nickolas Gadomski */
enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  public String code;

  /**
   * ItemType method accepts String item which passes enum variables.
   *
   * @param code field for passing
   */
  ItemType(String code) {
    this.code = code;
  }

  /**
   * Accessor for String item field.
   *
   * @return String item field / enum variables
   */
  public String getItem() {
    return code;
  }
}
