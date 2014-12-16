package habens.promotion;

import habens.item.Item;

import java.util.List;

/**
 * Created by habens on 11/21/14.
 */
public interface Promotion<T> {
    List<String> getItemIDList();
    Item update(Item item);
}
