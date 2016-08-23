package gildedrose.rules;

import gildedrose.Item;
import gildedrose.ItemTypes;
import gildedrose.Rules;

public class ImproveWithAgeRule implements Rules {

    public void update(Item item) {
        item.quality++;
    }

    public boolean appliesTo(Item item) {
        for (ItemTypes type : ItemTypes.values()) {
            if (type.title.equals(item.name)) { return type.improvesWithAge; }
        }
        return false;
    }
}
