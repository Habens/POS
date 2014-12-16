package habens.item;

/**
 * Created by habens on 11/21/14.
 */
public class NormalItem extends Item {
    public NormalItem(String ID, float price) {
        super(ID, price);
    }

    public String getDescription() {
        return "Normal";
    }

    public float cost(int number) {
        return getPrice() * number;
    }
}
