package gildedrose;

import gildedrose.rules.BrieRule;
import org.junit.Test;

import static gildedrose.ItemTestHelper.createItem;
import static gildedrose.ItemTestHelper.getItemQuality;
import static gildedrose.ItemTypes.*;
import static org.junit.Assert.*;

public class BrieRuleTest {

    private BrieRule brieRule = new BrieRule();
    private Item item;

    @Test
    public void theUpdateIsOnlyAppliedToAgedBrie() {
        item = createItem(BRIE.title, 4, 5);

        boolean isApplicable = brieRule.appliesTo(item);

        assertTrue(isApplicable);
    }

    @Test
    public void theUpdateIsNotAppliedToAnotherItem() {
        item = createItem("Not Brie", 4, 5);

        boolean isApplicable = brieRule.appliesTo(item);

        assertFalse(isApplicable);
    }

    @Test
    public void theQualityOfBrieIncreasesAfterSellInDateHasPassed() {
        item = createItem(BRIE.title, 0, 3);

        brieRule.update(item);

        assertEquals(4, getItemQuality(item));
    }
}
