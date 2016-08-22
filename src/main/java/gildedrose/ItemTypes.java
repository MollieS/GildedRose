package gildedrose;

public enum ItemTypes {

    BRIE ("Aged Brie"),
    PASSES ("Backstage passes to a TAFKAL80ETC concert") ,
    CONJURED ("Conjured Mana Cake"),
    SULFURAS ("Sulfuras, Hand of Ragnaros");

    public String title;

    ItemTypes(String title) {
        this.title = title;
    }

}
