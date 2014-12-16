package habens.item;

/**
 * Created by habens on 11/21/14.
 */
abstract public class ItemDecorator extends Item {

    public ItemDecorator(Item item) {
        super(item.getID(), item.getPrice());
    }

    abstract public String getDescription();
}
