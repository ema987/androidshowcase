package com.w3ma.androidshowcase.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.w3ma.androidshowcase.util.CustomRecyclerItemClickListener;
import com.w3ma.androidshowcase.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Emanuele on 07/11/2015.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.RecyclerViewHolder> {

    private List<MenuItem> menuItemList;
    private CustomRecyclerItemClickListener<MenuItem> customRecyclerItemClickListener;

    public void setItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public void setCustomRecyclerItemClickListener(CustomRecyclerItemClickListener<MenuItem> customRecyclerItemClickListener) {
        this.customRecyclerItemClickListener = customRecyclerItemClickListener;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.itemTextView)
        public TextView itemTextView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    customRecyclerItemClickListener.recyclerViewItemClicked(v, getLayoutPosition(), menuItemList.get(getLayoutPosition()));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(menuItemList != null)
            return menuItemList.size();
        return 0;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        if(menuItemList != null) {
            MenuItem menuItem = menuItemList.get(position);
            holder.itemTextView.setText(menuItem.getTitle());
        }
    }

}
