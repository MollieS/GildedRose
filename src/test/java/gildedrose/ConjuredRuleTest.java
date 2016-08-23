package gildedrose;

import gildedrose.rules.ConjuredRule;
import org.junit.Test;

import static gildedrose.ItemTestHelper.createItem;
import static gildedrose.ItemTestHelper.getItemQuality;
import static gildedrose.ItemTypes.CONJURED;
import static org.junit.Assert.*;

public class ConjuredRuleTest {

    private Item item;
    private ConjuredRule conjuredRule = new ConjuredRule();

    @Test
    public void theConjuredItemQualityDecreasesByAnExtraOne() {
        item = createItem(CONJURED.title, 2, 20);

        conjuredRule.update(item);

        assertEquals(19, getItemQuality(item));
    }

    @Test
    public void theConjuredItemDecreasesInQualityByAnotherExtraOneAfterSellInDateHasPassed() {
        item = createItem(CONJURED.title, -2, 20);

        conjuredRule.update(item);

        assertEquals(18, getItemQuality(item));
    }

    @Test
    public void theRuleOnlyAppliesToAConjuredItem() {
        item = createItem(CONJURED.title, -2, 0);

        boolean isApplicable = conjuredRule.appliesTo(item);

        assertTrue(isApplicable);
    }

    @Test
    public void theRuleDoesNotApplyToOtherItems() {
        item = createItem("Not Cake", -2, 0);

        boolean isApplicable = conjuredRule.appliesTo(item);

        assertFalse(isApplicable);
    }
}
