package chapter6;

public class Item {
    private String name;
    private Item prevItem;
    private Item nextItem;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getPrevItem() {
        return this.prevItem;
    }

    public Item getNextItem() {
        return this.nextItem;
    }

    public void setNextItem(Item nextItem) {
        this.nextItem = nextItem;
    }

    public void setPrevItem(Item prevItem) {
        this.prevItem = prevItem;
    }

}
