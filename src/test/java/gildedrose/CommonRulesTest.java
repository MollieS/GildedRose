package gildedrose;

import gildedrose.rules.CommonRules;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static gildedrose.ItemTestHelper.createItem;
import static gildedrose.ItemTestHelper.getItemQuality;
import static gildedrose.ItemTestHelper.getItemSellIn;
import static gildedrose.ItemTypes.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommonRulesTest {

    private CommonRules commonRules = new CommonRules();

    @Test
    public void areApplicableToAllItemsExceptSulfuras() {
        List<Item> items = createItems();

        boolean isApplicable = checkAllItemTypes(items);

        assertTrue(isApplicable);
    }

    @Test
    public void areNotApplicableToTheHandOfSulfuras() {
        Item item = new Item(SULFURAS.title, 4, 80);

        boolean isApplicable = commonRules.appliesTo(item);

        assertFalse(isApplicable);
    }

    @Test
    public void decreasesTheSellInDateByOne() {
        Item item = createItem("Normal Item", 4, 4);

        commonRules.update(item);

        assertEquals(3, getItemSellIn(item));
    }

    @Test
    public void doesNotAllowNegativeQuality() {
        Item item = createItem("Normal Item", 0, -3);

        commonRules.update(item);

        assertEquals(0, getItemQuality(item));
    }

    @Test
    public void doesNotAllowQualityOverFifty() {
        Item item = createItem("Normal Item", 3, 51);

        commonRules.update(item);

        assertEquals(50, getItemQuality(item));
    }

    private boolean checkAllItemTypes(List<Item> items) {
        for (Item item : items) {
            if (!commonRules.appliesTo(item)) {
                return false;
            }
        }
        return true;
    }

    private List<Item> createItems() {
        List<Item> items = new ArrayList<Item>();
        items.add(createItem("Normal", 4, 4));
        items.add(createItem(BRIE.title, 4, 4));
        items.add(createItem(CONJURED.title, 4, 4));
        items.add(createItem(PASSES.title, 4, 4));
        return items;
    }
}
