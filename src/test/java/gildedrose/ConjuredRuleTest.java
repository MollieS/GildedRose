package gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredRuleTest {

    private Item item;

    @Test
    public void theConjuredItemQualityDecreaseTwiceAsFastAsNormal() {
        item = createItem("Conjured Item", 2, 20);

        ConjuredRule conjuredRule = new ConjuredRule();

        conjuredRule.update(item);

        assertEquals(18, getItemQuality());
    }

    @Test
    public void theConjuredItemSellInDateDecreasesAfterAnUpdate() {
        item = createItem("Conjured Item", 2, 20);

        ConjuredRule conjuredRule = new ConjuredRule();

        conjuredRule.update(item);

        assertEquals(1, getItemSellIn());
    }

    @Test
    public void theConjuredItemDecreasesInQualityByFourAfterPassedSellInDate() {
        item = createItem("Conjured Item", -2, 20);

        ConjuredRule conjuredRule = new ConjuredRule();

        conjuredRule.update(item);

        assertEquals(16, getItemQuality());
    }

    @Test
    public void theConjuredItemQualityIsNeverNegative() {
        item = createItem("Conjured Item", -2, 0);

        ConjuredRule conjuredRule = new ConjuredRule();

        conjuredRule.update(item);

        assertEquals(0, getItemQuality());
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
