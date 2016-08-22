package gildedrose;

import gildedrose.rules.PassesRule;
import org.junit.Test;

import static gildedrose.ItemTestHelper.createItem;
import static gildedrose.ItemTestHelper.getItemQuality;
import static gildedrose.ItemTypes.PASSES;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PassesRuleTest {

    private Item item;
    private PassesRule passesRule = new PassesRule();

    @Test
    public void backstagePassesIncreaseInValueByAnExtraOneWhenSellInIsUnderTenDays() {
        item = createItem(PASSES.title, 9, 5);

        passesRule.update(item);

        assertEquals(6, getItemQuality(item));
    }

    @Test
    public void backstagePassesIncreaseInValueByAnExtraTwoWhenSellInDateIsLessThanFiveDays() {
        item = createItem(PASSES.title, 4, 5);

        passesRule.update(item);

        assertEquals(7, getItemQuality(item));
    }

    @Test
    public void whenSellInHasPassedQualityOfBackstagePassesIsZero() {
        item = createItem(PASSES.title, -1, 5);

        passesRule.update(item);

        assertEquals(0, getItemQuality(item));
    }

    @Test
    public void theRuleIsOnlyApplicableToBackstagePasses() {
        item = createItem(PASSES.title, 1, 2);

        boolean isApplicable = passesRule.appliesTo(item);

        assertTrue(isApplicable);
    }

    @Test
    public void theRuleIsNotApplicableToOtherItems() {
        item = createItem("cake", 1, 2);

        boolean isApplicable = passesRule.appliesTo(item);

        assertFalse(isApplicable);
    }
}
