package gildedrose.rules;

import gildedrose.Item;
import gildedrose.ItemTypes;
import gildedrose.Rules;

public class PassesRule extends CommonRules implements Rules {

    private int tenDays = 10;
    private int fiveDays = 5;
    private int concertDay = 0;

    public void update(Item item) {
        tenDaysTillSellIn(item);
        fiveDaysTillSellIn(item);
        sellInDatePassed(item);
        super.checkMaximumQuality(item);
    }

    public boolean appliesTo(Item item) {
        return item.name.equals(ItemTypes.PASSES.title);
    }

    private void sellInDatePassed(Item item) {
        if (item.sellIn < concertDay) {
            item.quality = 0;
        }
    }

    private void fiveDaysTillSellIn(Item item) {
        if (item.sellIn < fiveDays) {
            item.quality++;
        }
    }

    private void tenDaysTillSellIn(Item item) {
        if (item.sellIn < tenDays) {
            item.quality++;
        }
    }
}
