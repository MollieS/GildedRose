package gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BrieRuleTest {

    private BrieRule brieRule = new BrieRule();

    @Test
    public void theQualityOfBrieIncreasesAfterOneUpdate() {
        Item item = createItem("Aged Brie", 10, 3);

        brieRule.update(item);

        assertEquals(4, item.quality);
    }

    @Test
    public void theQualityOfBrieIncreasesByTwoAfterSellInDate() {
        Item item = createItem("Aged Brie", 0, 3);

        brieRule.update(item);

        assertEquals(5, item.quality);
    }

    @Test
    public void theQualityOfBrieCannotGoOverFifty() {
        Item item = createItem("Aged Brie", 0, 50);

        brieRule.update(item);

        assertEquals(50, item.quality);
    }

    @Test
    public void theSellInDateOfBrieDecreasesAfterAnUpdate() {
        Item item = createItem("Aged Brie", 4, 5);

        brieRule.update(item);

        assertEquals(3, item.sellIn);
    }

    @Test
    public void theUpdateIsOnlyAppliedToAgedBrie() {
        Item item = createItem("Aged Brie", 4, 5);

        boolean isApplicable = brieRule.appliesTo(item);

        assertTrue(isApplicable);
    }

    @Test
    public void theUpdateIsNotAppliedToAnotherItem() {
        Item item = createItem("Not Brie", 4, 5);

        boolean isApplicable = brieRule.appliesTo(item);

        assertFalse(isApplicable);
    }

    private Item createItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }
}
