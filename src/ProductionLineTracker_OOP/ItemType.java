package ProductionLineTracker_OOP;

/**
 * Enumeration list of variables for different product types
 * @Author: Nickolas Gadomski
 */
public enum ItemType {
        AUDIO ("AU"),
        VISUAL ("VI"),
        AUDIO_MOBILE ("AM"),
        VISUAL_MOBILE ("VM");

        public String item;

    /**
     * ItemType method accepts String item which passes enum variables
     * @param item field for passing
     */
    ItemType(String item){
        this.item = item;
    }

    /**
     * Accessor for String item field
     * @return  String item field / enum variables
     */
    public String getItem(){
        return item;
    }
}

