package com.windy.example.eventbuspractice;

import java.util.List;

/**
 * Created by windog on 2016/7/8.
 */
public class Event {

    /** 列表加载事件 */
    public static class ItemListEvent {
        private List<Item> items;

        public ItemListEvent(List<Item> items) {
            this.items = items;
        }

        public List<Item> getItems() {
            return items;
        }
    }
}
