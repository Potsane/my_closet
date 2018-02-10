package com.example.pmohale.mycloset.view.list;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.pmohale.mycloset.entity.WardrobeItem;

import java.util.List;

/**
 * Created by PMohale on 2018/02/10.
 */

class WardrobeItemsListAdapter extends RecyclerView.Adapter<WardrobeItemsListAdapter.WardrobeItemViewHolder>{

    private List<WardrobeItem> wardrobeItems;

    public WardrobeItemsListAdapter(List<WardrobeItem> wardrobeItems) {
        this.wardrobeItems = wardrobeItems;
    }

    @Override
    public WardrobeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(WardrobeItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class WardrobeItemViewHolder {
    }
}
