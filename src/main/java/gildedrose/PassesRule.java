package gildedrose;

public class PassesRule implements Rules {
    public void update(Item item) {
        passesUpdate(item);
        tenDaysTillSellIn(item);
        fiveDaysTillSellIn(item);
        maximumQualityCheck(item);
        sellInDatePassed(item);

    }

    private void sellInDatePassed(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void maximumQualityCheck(Item item) {
        if (item.quality >= 50) {
            item.quality = 50;
        }
    }

    private void fiveDaysTillSellIn(Item item) {
        if (item.sellIn < 5) {
            item.quality++;
        }
    }

    private void tenDaysTillSellIn(Item item) {
        if (item.sellIn < 10) {
            item.quality++;
        }
    }

    private void passesUpdate(Item item) {
        item.quality++;
        item.sellIn--;
    }
}
