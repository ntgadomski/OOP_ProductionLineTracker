package ProductionLineTracker_OOP;

public abstract class Product implements Item {
    private int id;
    private String type;
    private String manufacturer;
    private String name;

    public Product(String name, String manufacturer, String type){
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public int getId(){
        return id;
    }


    public void setId(int id){
        this.id = id;
    }
    @Override
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getManufacturer(){
        return manufacturer;
    }


    public String getType(){
        return type;
    }


    public void setType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        String str = String.format("Name: %s\nManufacturer: %s\nType: %s",
                this.name, this.manufacturer, this.type);
        return str;
    }
}
class Widget extends Product{
    Widget(String name, String manufacturer, String type){
        super(name, manufacturer, type);
    }
}
