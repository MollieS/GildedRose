package gildedrose;

public class NormalRule implements Rules {

    public void update(Item item) {
        itemUpdate(item);
        pastSellInDate(item);
        nonNegativeQuality(item);
    }

    public boolean appliesTo(Item item) {
        for (ItemTypes itemTypes : ItemTypes.values()) {
            if (item.name.equals(itemTypes.title)) {
                return false;
            }
        }
        return true;
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