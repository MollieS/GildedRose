package gildedrose;

import org.junit.Test;

import static gildedrose.ItemTestHelper.createItem;
import static gildedrose.ItemTypes.SULFURAS;
import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void formatsItems() {
        Item item = createItem(SULFURAS.title, 4, 80);

        String string = item.toString();

        assertEquals("Sulfuras, Hand of Ragnaros, 4, 80", string);
    }
}
