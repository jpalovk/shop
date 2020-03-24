package sample;

public class ModelTable {

    String id, name, price, available;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public ModelTable(String id, String name, String price, String available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = available;
    }
}
