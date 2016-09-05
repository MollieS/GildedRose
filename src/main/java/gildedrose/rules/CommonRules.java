package gildedrose.rules;

import gildedrose.Item;

public abstract class CommonRules {

    private final int maximumQuality = 50;
    private final int minimumQuality = 0;

    public void update(Item item) {
        decreaseSellIn(item);
        checkMinimumQuality(item);
        checkMaximumQuality(item);
    }

    public void checkMaximumQuality(Item item) {
        if (item.quality >= maximumQuality) { item.quality = maximumQuality; }
    }

    public void checkMinimumQuality(Item item) {
        if (item.quality <= minimumQuality) { item.quality = minimumQuality; }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}
