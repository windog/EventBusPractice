package com.windy.example.eventbuspractice;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.windy.example.eventbuspractice.Event.ItemListEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by windog on 2016/7/8.
 */
public class ItemListFragment extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 注册默认 EventBus
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 取消注册默认 Eventbus
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Thread() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    EventBus.getDefault().post(new ItemListEvent(Item.items));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            };
        }.start();
    }

    public void onEventMainThread(ItemListEvent event) {
        setListAdapter(new ArrayAdapter<Item>(getActivity(),
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1, event.getItems()));
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        EventBus.getDefault().post(getListView().getItemAtPosition(position));
    }
}
