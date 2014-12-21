package habens.item;

/**
 * Created by habens on 11/21/14.
 */
public class DiscountItem extends ItemDecorator {
    private Item item;
    private float discount;

    public DiscountItem(Item item, float discount) {
        super(item);
        this.item = item;
        this.discount = discount;
    }

    public String getDescription() {
        return "| " + discount + " Discount " + item.getDescription();
    }

    public float cost(int number) {
        return (item.cost() * discount / 100) * number;
    }
}
