package gildedrose;

public class ItemTestHelper {

    public static Item createItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    public static int getItemQuality(Item item) {
        return item.quality;
    }

    public static int getItemSellIn(Item item) {
        return item.sellIn;
    }
}
