package gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NormalRuleTest {

    private NormalRule normalRule = new NormalRule();

    @Test
    public void theQualityOfANormalItemDecreasesByOneAfterOneUpdate() {
        Item item = createItem("normal", 5, 5);

        normalRule.update(item);

        assertEquals(4, item.quality);
    }

    @Test
    public void theSellInValueOfANormalItemDecresesByOneAfterOneUpdate() {
        Item item = createItem("normal", 5, 5);

        normalRule.update(item);

        assertEquals(4, item.sellIn);
    }

    @Test
    public void theSellInIsNegativeAfterItHasPassed() {
        Item item = createItem("normal", 0, 5);

        normalRule.update(item);

        assertEquals(-1, item.sellIn);
    }

    @Test
    public void theRuleIsAppliedToNormalItems() {
        Item item = createItem("normal", 0, 5);

        boolean isApplicable = normalRule.appliesTo(item);

        assertTrue(isApplicable);
    }

    @Test
    public void theRuleIsNotApplicableToOtherItems() {
        Item item = createItem("Aged Brie", 3, 3);

        boolean isApplicable = normalRule.appliesTo(item);

        assertFalse(isApplicable);
    }

    private Item createItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }
}
