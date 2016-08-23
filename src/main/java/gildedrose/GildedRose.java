package gildedrose;


public class GildedRose {

    private final Rules[] rules;
    public final Item[] items;

    public GildedRose(Item[] items, Rules[] rules) {
        this.rules = rules;
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        for (Rules rule : rules) {
            applyRule(item, rule);
        }
    }

    private void applyRule(Item item, Rules rule) {
        if (rule.appliesTo(item)) {
            rule.update(item);
        }
    }
}
