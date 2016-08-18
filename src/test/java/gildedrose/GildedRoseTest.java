package gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void theQualityOfANormalItemDecreasesByOneAfterOneUpdate() {
        Item normalItem = new Item("normal", 5, 5);
        updateGildedRose(normalItem);
        assertEquals(4, normalItem.quality);
    }

    @Test
    public void theSellInValueOfANormalItemDecresesByOneAfterOneUpdate() {
        Item normalItem = new Item("normal", 5, 5);
        updateGildedRose(normalItem);
        assertEquals(4, normalItem.sellIn);
    }

    @Test
    public void whenTheSellInValueIsZeroQualityOfANormalItemDecreasesByTwo() {
        Item normalItem = new Item("normal", 0, 5);
        updateGildedRose(normalItem);
        assertEquals(3, normalItem.quality);
    }

    @Test
    public void theQualityOfANormalItemIsNeverNegative() {
        Item normalItem = new Item("normal", 0, 0);
        updateGildedRose(normalItem);
        assertEquals(0, normalItem.quality);
    }

    @Test
    public void theQualityOfBrieIncreasesAfterOneUpdate() {
        Item brie = new Item("Aged Brie", 10, 3);
        updateGildedRose(brie);
        assertEquals(4, brie.quality);
    }

    @Test
    public void theQualityOfBrieIncreasesByTwoAfterSellInDate() {
        Item brie = new Item("Aged Brie", 0, 3);
        updateGildedRose(brie);
        assertEquals(5, brie.quality);
    }

    @Test
    public void theQualityOfBrieCannotGoOverFifty() {
        Item brie = new Item("Aged Brie", 0, 50);
        updateGildedRose(brie);
        assertEquals(50, brie.quality);
    }

    @Test
    public void theSellInDateOfBrieDecreasesAfterAnUpdate() {
        Item brie = new Item("Aged Brie", 4, 5);
        updateGildedRose(brie);
        assertEquals(3, brie.sellIn);
    }

    @Test
    public void backstagePassesIncreaseInValueByOneWhenSellInIsOverTenDays() {
        Item passes = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 5);
        updateGildedRose(passes);
        assertEquals(6, passes.quality);
    }

    @Test
    public void backstagePassesIncreaseInValueByTwoWhenSellInIsUnderTenDays() {
        Item passes = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 5);
        updateGildedRose(passes);
        assertEquals(7, passes.quality);
    }

    @Test
    public void backstagePassesIncreaseInValueByThreeWhenSellInIsUnderFiveDays() {
        Item passes = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5);
        updateGildedRose(passes);
        assertEquals(8, passes.quality);
    }

    @Test
    public void theValueOfBackstagePassesCannotRiseAboveFifty() {
        Item passes = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50);
        updateGildedRose(passes);
        assertEquals(50, passes.quality);
    }

    @Test
    public void whenSellInHasPassedQualityOfBackstagePassesIsZero() {
        Item passes = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50);
        updateGildedRose(passes);
        assertEquals(0, passes.quality);
    }

    @Test
    public void theSellInValueDecreasesAfterAnUpdate() {
        Item passes = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 2);
        updateGildedRose(passes);
        assertEquals(0, passes.sellIn);
    }

    @Test
    public void theHandOfSulfurasDoesNotDecreaseInQuality() {
        Item hand = new Item("Sulfuras, Hand of Ragnaros", 2, 80);
        updateGildedRose(hand);
        assertEquals(80, hand.quality);
    }

    @Test
    public void theHandOfSulfurasSellInDateDoesNotDecrease() {
        Item hand = new Item("Sulfuras, Hand of Ragnaros", 2, 80);
        updateGildedRose(hand);
        assertEquals(2, hand.sellIn);
    }

    private void updateGildedRose(Item item) {
        Item[] items = {item};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
    }
}
