package habens.item;

/**
 * Created by habens on 11/21/14.
 */
abstract public class Item {
    private String ID;
    private float price;

    public Item(String ID, float price) {
        this.ID = ID;
        this.price = price;
    }

    public String getDescription() {
        return "Unknown Item";
    }

    public String getID() {
        return ID;
    }

    public float getPrice() {
        return price;
    }

    abstract public float cost(int number);

    public float cost() {
        return cost(1);
    }
}