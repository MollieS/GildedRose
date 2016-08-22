package gildedrose;

import gildedrose.rules.DeterioratesWithAgeRule;
import org.junit.Test;

import static gildedrose.ItemTestHelper.createItem;
import static gildedrose.ItemTestHelper.getItemQuality;
import static gildedrose.ItemTypes.BRIE;
import static gildedrose.ItemTypes.CONJURED;
import static gildedrose.ItemTypes.SULFURAS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeterioratesWithAgeRuleTest {

    private DeterioratesWithAgeRule deterioratesWithAgeRule = new DeterioratesWithAgeRule();

    @Test
    public void appliesToNormalItems() {
        Item item = createItem("Normal", 4, 4);

        boolean isApplicable = deterioratesWithAgeRule.appliesTo(item);

        assertTrue(isApplicable);
    }

    @Test
    public void appliesToConjoinedItems() {
        Item item = createItem(CONJURED.title, 4, 4);

        boolean isApplicable = deterioratesWithAgeRule.appliesTo(item);

        assertTrue(isApplicable);
    }

    @Test
    public void doesNotApplyToBrie() {
        Item item = createItem(BRIE.title, 4, 4);

        boolean isApplicable = deterioratesWithAgeRule.appliesTo(item);

        assertFalse(isApplicable);
    }

    @Test
    public void doesNotApplyToSulfuras() {
        Item item = createItem(SULFURAS.title, 4, 4);

        boolean isApplicable = deterioratesWithAgeRule.appliesTo(item);

        assertFalse(isApplicable);
    }

    @Test
    public void decreasesQualityByOne() {
        Item item = createItem(CONJURED.title, 4, 4);

        deterioratesWithAgeRule.update(item);

        assertEquals(3, getItemQuality(item));
    }

    @Test
    public void decreasesQualityByAnExtraOneIfSellInDateHasPasses() {
        Item item = createItem(CONJURED.title, 0, 4);

        deterioratesWithAgeRule.update(item);

        assertEquals(2, getItemQuality(item));
    }
}
