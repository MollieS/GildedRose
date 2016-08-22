package gildedrose;

import gildedrose.rules.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private GildedRose gildedRose;

    @Test
    public void theQualityOfANormalItemDecreasesByOneAfterOneUpdate() {
        gildedRose = createGildedRose(createItem("normal", 5, 5));

        gildedRose.updateQuality();

        assertEquals(4, getItemQuality());
    }

    @Test
    public void theSellInValueOfANormalItemDecresesByOneAfterOneUpdate() {
        gildedRose = createGildedRose(createItem("normal", 5, 5));

        gildedRose.updateQuality();

        assertEquals(4, getItemSellIn());
    }

    @Test
    public void theSellInIsNegativeAfterItHasPassed() {
        gildedRose = createGildedRose(createItem("normal", 0, 5));

        gildedRose.updateQuality();

        assertEquals(-1, getItemSellIn());
    }

    @Test
    public void whenTheSellInValueIsZeroQualityOfANormalItemDecreasesByTwo() {
        gildedRose = createGildedRose(createItem("normal", 0, 5));

        gildedRose.updateQuality();

        assertEquals(3, getItemQuality());
    }

    @Test
    public void theQualityOfANormalItemIsNeverNegative() {
        gildedRose = createGildedRose(createItem("normal", 0, 0));

        gildedRose.updateQuality();

        assertEquals(0, getItemQuality());
    }

    @Test
    public void theQualityOfBrieIncreasesAfterOneUpdate() {
        gildedRose = createGildedRose(createItem("Aged Brie", 10, 3));

        gildedRose.updateQuality();

        assertEquals(4, getItemQuality());
    }

    @Test
    public void theQualityOfBrieIncreasesByTwoAfterSellInDate() {
        gildedRose = createGildedRose(createItem("Aged Brie", 0, 3));

        gildedRose.updateQuality();

        assertEquals(5, getItemQuality());
    }

    @Test
    public void theQualityOfBrieCannotGoOverFifty() {
        gildedRose = createGildedRose(createItem("Aged Brie", 0, 50));

        gildedRose.updateQuality();

        assertEquals(50, getItemQuality());
    }

    @Test
    public void theSellInDateOfBrieDecreasesAfterAnUpdate() {
        gildedRose = createGildedRose(createItem("Aged Brie", 4, 5));

        gildedRose.updateQuality();

        assertEquals(3, getItemSellIn());
    }

    @Test
    public void backstagePassesIncreaseInValueByOneWhenSellInIsOverTenDays() {
        gildedRose = createGildedRose(createItem("Backstage passes to a TAFKAL80ETC concert", 15, 5));

        gildedRose.updateQuality();

        assertEquals(6, getItemQuality());
    }

    @Test
    public void backstagePassesIncreaseInValueByTwoWhenSellInIsUnderTenDays() {
        gildedRose = createGildedRose(createItem("Backstage passes to a TAFKAL80ETC concert", 9, 5));

        gildedRose.updateQuality();

        assertEquals(7, getItemQuality());
    }

    @Test
    public void backstagePassesIncreaseInValueByThreeWhenSellInIsUnderFiveDays() {
        gildedRose = createGildedRose(createItem("Backstage passes to a TAFKAL80ETC concert", 4, 5));

        gildedRose.updateQuality();

        assertEquals(8, getItemQuality());
    }

    @Test
    public void theValueOfBackstagePassesCannotRiseAboveFifty() {
        gildedRose = createGildedRose(createItem("Backstage passes to a TAFKAL80ETC concert", 1, 50));

        gildedRose.updateQuality();

        assertEquals(50, getItemQuality());
    }

    @Test
    public void whenSellInHasPassedQualityOfBackstagePassesIsZero() {
        gildedRose = createGildedRose(createItem("Backstage passes to a TAFKAL80ETC concert", 0, 50));

        gildedRose.updateQuality();

        assertEquals(0, getItemQuality());
    }

    @Test
    public void theSellInValueDecreasesAfterAnUpdate() {
        gildedRose = createGildedRose(createItem("Backstage passes to a TAFKAL80ETC concert", 1, 2));

        gildedRose.updateQuality();

        assertEquals(0, getItemSellIn());
    }

    @Test
    public void theHandOfSulfurasDoesNotDecreaseInQuality() {
        gildedRose = createGildedRose(createItem("Sulfuras, Hand of Ragnaros", 2, 80));

        gildedRose.updateQuality();

        assertEquals(80, getItemQuality());
    }

    @Test
    public void theHandOfSulfurasSellInDateDoesNotDecrease() {
        gildedRose = createGildedRose(createItem("Sulfuras, Hand of Ragnaros", 2, 80));

        gildedRose.updateQuality();

        assertEquals(2, getItemSellIn());
    }

    @Test
    public void theConjuredItemQualityDecreaseTwiceAsFastAsNormal() {
        gildedRose = createGildedRose(createItem("Conjured Mana Cake", 2, 20));

        gildedRose.updateQuality();

        assertEquals(18, getItemQuality());
    }

    @Test
    public void theConjuredItemSellInDateDecreasesAfterAnUpdate() {
        gildedRose = createGildedRose(createItem("Conjured Mana Cake", 2, 20));

        gildedRose.updateQuality();

        assertEquals(1, getItemSellIn());
    }

    @Test
    public void theConjuredItemDecreasesInQualityByFourAfterPassedSellInDate() {
        gildedRose = createGildedRose(createItem("Conjured Mana Cake", -2, 20));

        gildedRose.updateQuality();

        assertEquals(16, getItemQuality());
    }

    @Test
    public void theConjuredItemQualityIsNeverNegative() {
        gildedRose = createGildedRose(createItem("Conjured Mana Cake", -2, 0));

        gildedRose.updateQuality();

        assertEquals(0, getItemQuality());
    }

    private GildedRose createGildedRose(Item item) {
        Item[] items = {item};
        Rules[] rules = new Rules[]{new BrieRule(), new DeterioratesWithAgeRule(), new ImproveWithAgeRule(), new BackstagePassesRule(), new ConjuredRule()};
        return new GildedRose(items, rules);
    }

    private Item createItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    private int getItemQuality() {
        return gildedRose.items[0].quality;
    }

    private int getItemSellIn() {
        return gildedRose.items[0].sellIn;
    }
}
