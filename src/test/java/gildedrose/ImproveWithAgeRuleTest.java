package gildedrose;

import gildedrose.rules.ImproveWithAgeRule;
import org.junit.Test;

import static gildedrose.ItemTestHelper.createItem;
import static gildedrose.ItemTestHelper.getItemQuality;
import static gildedrose.ItemTypes.BRIE;
import static gildedrose.ItemTypes.PASSES;
import static gildedrose.ItemTypes.SULFURAS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ImproveWithAgeRuleTest {

    private ImproveWithAgeRule improveWithAgeRule = new ImproveWithAgeRule();

    @Test
    public void isApplicableToBrie() {
        Item item = createItem(BRIE.title, 4, 4);

        boolean isApplicable = improveWithAgeRule.appliesTo(item);

        assertTrue(isApplicable);
    }

    @Test
    public void isNotApplicableToNormalItems() {
        Item item = createItem("Normal Item", 4, 4);

        boolean isApplicable = improveWithAgeRule.appliesTo(item);

        assertFalse(isApplicable);
    }

    @Test
    public void isApplicableToBackStagePasses() {
        Item item = createItem(PASSES.title, 4, 4);

        boolean isApplicable = improveWithAgeRule.appliesTo(item);

        assertTrue(isApplicable);
    }

    @Test
    public void doesNotApplyToHandOfSulfuras() {
        Item item = createItem(SULFURAS.title, 4, 80);

        boolean isApplicable = improveWithAgeRule.appliesTo(item);

        assertFalse(isApplicable);
    }

    @Test
    public void increasesQualityByOne() {
        Item item = createItem(PASSES.title, 4, 4);

        improveWithAgeRule.update(item);

        assertEquals(5, getItemQuality(item));
    }

}
