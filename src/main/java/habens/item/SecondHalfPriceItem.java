package habens.item;

/**
 * Created by habens on 11/21/14.
 */
public class SecondHalfPriceItem extends ItemDecorator {
    private Item item;

    public SecondHalfPriceItem(Item item) {
        super(item);
        this.item = item;
    }

    public String getDescription() {
        return "| Second Half Price " + item.getDescription();
    }

    public float cost(int number) {
        return item.cost(number) - (item.cost(number) / number / 2) * (number / 2);
    }
}
