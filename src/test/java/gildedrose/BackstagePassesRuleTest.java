package gildedrose;

import gildedrose.rules.BackstagePassesRule;
import org.junit.Test;

import static gildedrose.ItemTestHelper.createItem;
import static gildedrose.ItemTestHelper.getItemQuality;
import static gildedrose.ItemTypes.PASSES;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BackstagePassesRuleTest {

    private Item item;
    private BackstagePassesRule backstagePassesRule = new BackstagePassesRule();

    @Test
    public void backstagePassesIncreaseInValueByAnExtraOneWhenSellInIsUnderTenDays() {
        item = createItem(PASSES.title, 9, 5);

        backstagePassesRule.update(item);

        assertEquals(6, getItemQuality(item));
    }

    @Test
    public void backstagePassesIncreaseInValueByAnExtraTwoWhenSellInDateIsLessThanFiveDays() {
        item = createItem(PASSES.title, 4, 5);

        backstagePassesRule.update(item);

        assertEquals(7, getItemQuality(item));
    }

    @Test
    public void whenSellInHasPassedQualityOfBackstagePassesIsZero() {
        item = createItem(PASSES.title, -1, 5);

        backstagePassesRule.update(item);

        assertEquals(0, getItemQuality(item));
    }

    @Test
    public void theRuleIsOnlyApplicableToBackstagePasses() {
        item = createItem(PASSES.title, 1, 2);

        boolean isApplicable = backstagePassesRule.appliesTo(item);

        assertTrue(isApplicable);
    }

    @Test
    public void theRuleIsNotApplicableToOtherItems() {
        item = createItem("cake", 1, 2);

        boolean isApplicable = backstagePassesRule.appliesTo(item);

        assertFalse(isApplicable);
    }
}
