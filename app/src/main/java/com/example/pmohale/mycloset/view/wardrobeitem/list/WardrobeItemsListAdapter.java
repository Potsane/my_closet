package com.example.pmohale.mycloset.view.wardrobeitem.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmohale.mycloset.R;
import com.example.pmohale.mycloset.entity.WardrobeItem;

import java.util.List;

/**
 * Created by PMohale on 2018/02/10.
 */

class WardrobeItemsListAdapter extends RecyclerView.Adapter<WardrobeItemsListAdapter.WardrobeItemViewHolder> {

    private List<WardrobeItem> wardrobeItems;

    private WardrobeItemsListAdapterOnItemClickHandler onItemClickHandler;

    public WardrobeItemsListAdapter(List<WardrobeItem> wardrobeItems, WardrobeItemsListAdapterOnItemClickHandler onItemClickHandler) {
        this.wardrobeItems = wardrobeItems;
        this.onItemClickHandler = onItemClickHandler;
    }

    @Override
    public WardrobeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_wardrobe_items, parent, false);
        return new WardrobeItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WardrobeItemViewHolder holder, int position) {
        WardrobeItem wardrobeItem = wardrobeItems.get(position);

        holder.descriptionTextView.setText(wardrobeItem.getColor() + " " + wardrobeItem.getType());
        holder.conditionsTextView.setText(wardrobeItem.getSuitableDressCode() + " " + wardrobeItem.getSuitableWeatherCondition());
        holder.idTextView.setText(Long.toString(wardrobeItem.getId()));

    }

    @Override
    public int getItemCount() {
        if (wardrobeItems == null) {
            return 0;
        }
        return wardrobeItems.size();
    }

    public void setWardrobeItems(List<WardrobeItem> wardrobeItems) {
        this.wardrobeItems = wardrobeItems;
        notifyDataSetChanged();
    }

    public class WardrobeItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView descriptionTextView;
        TextView conditionsTextView;
        TextView idTextView;

        public WardrobeItemViewHolder(View view) {
            super(view);
            descriptionTextView = view.findViewById(R.id.text_view_description);
            conditionsTextView = view.findViewById(R.id.text_view_usage);
            idTextView = view.findViewById(R.id.text_view_id);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            long id = wardrobeItems.get(position).getId();
            onItemClickHandler.onItemClick(id);
        }
    }

    public interface WardrobeItemsListAdapterOnItemClickHandler {
        void onItemClick(long id);
    }
}
