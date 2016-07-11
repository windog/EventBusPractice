package com.windy.example.eventbuspractice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by windog on 2016/7/8.
 */
public class Item {
    public String id;
    public String content;

    public Item(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public static List<Item> items = new ArrayList<Item>();

    private static void addItem(Item item)
    {
        items.add(item);
    }

    static {
        // Add 6 sample items.
        addItem(new Item("1", "Item 1"));
        addItem(new Item("2", "Item 2"));
        addItem(new Item("3", "Item 3"));
        addItem(new Item("4", "Item 4"));
        addItem(new Item("5", "Item 5"));
        addItem(new Item("6", "Item 6"));
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
