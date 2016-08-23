package gildedrose.rules;

import gildedrose.Item;
import gildedrose.ItemTypes;
import gildedrose.Rules;

public class BrieRule implements Rules {

    public void update(Item item) {
        if (sellInDateIsPassed(item)) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }

    private boolean sellInDateIsPassed(Item item) {
        return (item.sellIn <= 0);
    }

    public boolean appliesTo(Item item) {
        return item.name.equals(ItemTypes.BRIE.title);
    }
}
