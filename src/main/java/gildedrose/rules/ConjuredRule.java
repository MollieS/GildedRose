package gildedrose.rules;

import gildedrose.Item;
import gildedrose.ItemTypes;
import gildedrose.Rules;

public class ConjuredRule extends CommonRules implements Rules {

    public void update(Item item) {
        decreaseQuality(item);
        passedSellInDate(item);
        super.checkMinimumQuality(item);
    }

    public boolean appliesTo(Item item) {
        return item.name.equals(ItemTypes.CONJURED.title);
    }

    private void passedSellInDate(Item item) {
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        item.quality--;
    }
}
