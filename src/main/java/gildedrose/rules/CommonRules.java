package gildedrose.rules;

import gildedrose.Item;
import gildedrose.ItemTypes;
import gildedrose.Rules;

public class CommonRules implements Rules {

    private final int maximumQuality = 50;
    private final int minimumQuality = 0;

    public void update(Item item) {
        decreaseSellIn(item);
        checkMinimumQuality(item);
        checkMaximumQuality(item);
    }

    public boolean appliesTo(Item item) {
        if (item.name.equals(ItemTypes.SULFURAS.title)) { return false; }
        return true;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void checkMaximumQuality(Item item) {
        if (item.quality >= maximumQuality) { item.quality = 50; }
    }

    private void checkMinimumQuality(Item item) {
        if (item.quality <= minimumQuality) { item.quality = 0; }
    }
}
