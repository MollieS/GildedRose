package gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConjuredRuleTest {

    private Item item;
    private ConjuredRule conjuredRule = new ConjuredRule();

    @Test
    public void theConjuredItemQualityDecreaseTwiceAsFastAsNormal() {
        item = createItem("Conjured Mana Cake", 2, 20);

        conjuredRule.update(item);

        assertEquals(18, getItemQuality());
    }

    @Test
    public void theConjuredItemSellInDateDecreasesAfterAnUpdate() {
        item = createItem("Conjured Mana Cake", 2, 20);

        conjuredRule.update(item);

        assertEquals(1, getItemSellIn());
    }

    @Test
    public void theConjuredItemDecreasesInQualityByFourAfterPassedSellInDate() {
        item = createItem("Conjured Mana Cake", -2, 20);

        conjuredRule.update(item);

        assertEquals(16, getItemQuality());
    }

    @Test
    public void theConjuredItemQualityIsNeverNegative() {
        item = createItem("Conjured Mana Cake", -2, 0);

        conjuredRule.update(item);

        assertEquals(0, getItemQuality());
    }

    @Test
    public void theRuleOnlyAppliesToAConjuredItem() {
        item = createItem("Conjured Mana Cake", -2, 0);

        boolean isApplicable = conjuredRule.appliesTo(item);

        assertTrue(isApplicable);
    }

    @Test
    public void theRuleDoesNotApplyToOtherItems() {
        item = createItem("Not Cake", -2, 0);

        boolean isApplicable = conjuredRule.appliesTo(item);

        assertFalse(isApplicable);
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
