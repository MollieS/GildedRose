package gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalRuleTest {
    @Test
   public void theQualityOfANormalItemDecreasesByOneAfterOneUpdate() {
        NormalRule normalRule = new NormalRule();
        Item item = createItem("normal", 5, 5);
        normalRule.update(item);
        assertEquals(4, item.quality);
    }
    @Test
    public void theSellInValueOfANormalItemDecresesByOneAfterOneUpdate() {
        NormalRule normalRule = new NormalRule();
        Item item = createItem("normal", 5, 5);
        normalRule.update(item);
        assertEquals(4, item.sellIn);
    }
    @Test
    public void theSellInIsNegativeAfterItHasPassed() {
        NormalRule normalRule = new NormalRule();
        Item item = createItem("normal", 0, 5);
        normalRule.update(item);
        assertEquals(-1, item.sellIn);
    }

    private Item createItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }
}
