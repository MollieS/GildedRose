package gildedrose;

public enum ItemTypes {

    BRIE ("Aged Brie", true, false),
    PASSES ("Backstage passes to a TAFKAL80ETC concert", true, false),
    CONJURED ("Conjured Mana Cake", false, true),
    SULFURAS ("Sulfuras, Hand of Ragnaros", false, false);

    public final boolean improvesWithAge;
    public final String title;
    public boolean deterioratesWithAge;

    ItemTypes(String title, boolean improvesWithAge, boolean deterioratesWithAge) {
        this.title = title;
        this.improvesWithAge = improvesWithAge;
        this.deterioratesWithAge = deterioratesWithAge;
    }
}
