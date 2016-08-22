package gildedrose;

public class BrieRule implements Rules {

    public void update(Item item) {
        brieUpdate(item);
        passedSellInDate(item);
        checkForMaximumQuality(item);
    }

    private void brieUpdate(Item item) {
        item.quality++;
        item.sellIn--;
    }

    private void checkForMaximumQuality(Item item) {
        if (item.quality >= 50) {
            item.quality = 50;
        }
    }

    private void passedSellInDate(Item item) {
        if (item.sellIn <= 0) {
            item.quality++;
        }
    }
}
