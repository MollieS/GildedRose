package gildedrose.rules;

import gildedrose.Item;
import gildedrose.ItemTypes;
import gildedrose.Rules;

import static gildedrose.ItemTypes.*;

public class DeterioratesWithAgeRule extends CommonRules implements Rules {

    public void update(Item item) {
        decreaseQuality(item);
        if (sellInDateHasPassed(item)) {
            decreaseQuality(item);
        }
        super.update(item);
    }

    private void decreaseQuality(Item item) {
        item.quality--;
    }

    private boolean sellInDateHasPassed(Item item) {
        return item.sellIn <= 0;
    }

    public boolean appliesTo(Item item) {
        for (ItemTypes type : values()) {
            if (itemIsRecognised(item, type)) { return type.deterioratesWithAge; }
        }
        return true;
    }

    private boolean itemIsRecognised(Item item, ItemTypes type) {
        return item.name.equals(type.title);
    }
}
