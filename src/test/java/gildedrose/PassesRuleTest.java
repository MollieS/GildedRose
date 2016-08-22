package gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassesRuleTest {

    private Item item;

    @Test
    public void backstagePassesIncreaseInValueByOneWhenSellInIsOverTenDays() {
        item = createItem("Backstage passes to a TAFKAL80ETC concert", 15, 5);

        PassesRule passesRule = new PassesRule();

        passesRule.update(item);

        assertEquals(6, getItemQuality());
    }

    @Test
    public void backstagePassesIncreaseInValueByTwoWhenSellInIsUnderTenDays() {
        item = createItem("Backstage passes to a TAFKAL80ETC concert", 9, 5);

        PassesRule passesRule = new PassesRule();

        passesRule.update(item);

        assertEquals(7, getItemQuality());
    }

    @Test
    public void backstagePassesIncreaseInValueByThreeWhenSellInIsUnderFiveDays() {
        item = createItem("Backstage passes to a TAFKAL80ETC concert", 4, 5);

        PassesRule passesRule = new PassesRule();

        passesRule.update(item);

        assertEquals(8, getItemQuality());
    }

    @Test
    public void theValueOfBackstagePassesCannotRiseAboveFifty() {
        item = createItem("Backstage passes to a TAFKAL80ETC concert", 1, 50);

        PassesRule passesRule = new PassesRule();

        passesRule.update(item);

        assertEquals(50, getItemQuality());
    }

    @Test
    public void whenSellInHasPassedQualityOfBackstagePassesIsZero() {
        item = createItem("Backstage passes to a TAFKAL80ETC concert", 0, 5);

        PassesRule passesRule = new PassesRule();

        passesRule.update(item);

        assertEquals(0, getItemQuality());
    }

    @Test
    public void theSellInValueDecreasesAfterAnUpdate() {
        item = createItem("Backstage passes to a TAFKAL80ETC concert", 1, 2);

        PassesRule passesRule = new PassesRule();

        passesRule.update(item);

        assertEquals(0, getItemSellIn());
    }

    private Item createItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    private int getItemQuality() {
        return item.quality;
    }

    private int getItemSellIn() {
        return item.sellIn;
    }
}
