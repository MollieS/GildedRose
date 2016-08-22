package gildedrose;


public class GildedRose {

    private final Rules[] rules;
    Item[] items;

    public GildedRose(Item[] items, Rules[] rules) {
        this.rules = rules;
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            for (Rules rule : rules) {
                if (rule.appliesTo(item)) {
                    rule.update(item);
                }
            }
        }
    }
}
