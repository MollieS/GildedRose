package gildedrose;

public interface Rules {

    void update(Item item);

    boolean appliesTo(Item item);
}
