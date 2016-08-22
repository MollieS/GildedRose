package gildedrose;

public class ConjuredRule implements Rules {

    public void update(Item item) {
        conjuredUpdate(item);
        passedSellInDate(item);
        nonNegativeQuality(item);
    }

    public boolean appliesTo(Item item) {
        return item.name.equals(ItemTypes.CONJURED.title);
    }

    private void nonNegativeQuality(Item item) {
        if (item.quality <= 0) {
            item.quality = 0;
        }
    }

    private void passedSellInDate(Item item) {
        if (item.sellIn < 0) {
            item.quality -= 2;
        }
    }

    private void conjuredUpdate(Item item) {
        item.quality -= 2;
        item.sellIn--;
    }
}
