package com.example.android.recyclerview;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.recyclerview.GreenAdapter.ItemViewHolder;
import java.util.List;

class GreenAdapter extends RecyclerView.Adapter<ItemViewHolder>
{
    int m_nItemSize;

    public GreenAdapter(int nSize)
    {
        this.m_nItemSize = nSize;
    }
    public void setDataSource(int nSize)
    {
        m_nItemSize = nSize;
    }

    // create view holders to cache inflated views in
    @Override
    public ItemViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        // parent viewgroup is a dummy root viewgroup container to hold all the view holders.
        View itemListRoot = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_list_item, parent, false);

        //instantiating ViewHolder
        ItemViewHolder viewHolder = new ItemViewHolder(itemListRoot);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.itemNumberTextView.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return this.m_nItemSize;
    }

    //caching view before binding.
    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemNumberTextView;
        // root view of the item in item.xml normally.
        public ItemViewHolder(final View itemView) {
            super(itemView);
            itemNumberTextView = (TextView) itemView.findViewById(R.id.tv_item_number);
        }
    }
}