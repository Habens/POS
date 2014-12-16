package habens.util;

/**
 * Created by habens on 12/13/14.
 */
public class SubTotal {
    private String itemID;
    private int number;
    private float price;
    private float original;
    private float subtotal;
    private float reduce;

    public SubTotal(String itemID, int number, float price, float original, float subtotal, float reduce) {
        this.itemID = itemID;
        this.number = number;
        this.price = price;
        this.original = original;
        this.subtotal = subtotal;
        this.reduce = reduce;
    }

    public void show() {
        System.out.println(itemID + " " +
                number + " " +
                price + " " +
                original + " " +
                reduce);
    }
}
