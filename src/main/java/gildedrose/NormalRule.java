package gildedrose;

public class NormalRule implements Rules {

    public void update(Item item) {
        itemUpdate(item);
        pastSellInDate(item);
        nonNegativeQuality(item);
    }

    private void itemUpdate(Item item) {
        item.quality--;
        item.sellIn--;
    }

    private void nonNegativeQuality(Item item) {
        if (item.quality <= 0) {
            item.quality = 0;
        }
    }

    private void pastSellInDate(Item item) {
        if (item.sellIn <= 0) {
            item.quality--;
        }
    }
}