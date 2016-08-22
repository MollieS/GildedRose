package gildedrose;


public class GildedRose {

    private final Rules passesRule;
    private final Rules conjuredRule;
    private final Rules brieRule;
    private final Rules normalRule;
    Item[] items;

    public GildedRose(Item[] items, Rules brieRule, Rules normalRule, Rules passesRule, Rules conjuredRule) {
        this.brieRule = brieRule;
        this.conjuredRule = conjuredRule;
        this.normalRule = normalRule;
        this.passesRule = passesRule;
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                brieRule.update(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                passesRule.update(item);
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            } else if (item.name.equals("Conjured Item")) {
                conjuredRule.update(item);
            } else {
                normalRule.update(item);
            }
        }
    }
}
