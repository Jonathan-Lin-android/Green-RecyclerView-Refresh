package com.example.android.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.android.recyclerview.GreenAdapter.ItemViewHolder;


class GreenAdapter extends RecyclerView.Adapter<ItemViewHolder>
{
    private int m_nItemSize = 0;
    private int m_iItemList = 0;

    private final ListItemClickListener mListItemClickListener;

    public GreenAdapter(int nSize, ListItemClickListener clickListener)
    {
        this.m_nItemSize = nSize;
        mListItemClickListener = clickListener;
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
        viewHolder.itemView.setBackgroundColor(ColorUtils.getViewHolderBackgroundColorFromInstance(viewHolder.itemView.getContext(), m_iItemList));
        viewHolder.itemIndexTextView.setText("ViewHolder index: " + m_iItemList++);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        TextView itemNumberTextView = holder.itemNumberTextView;
        itemNumberTextView.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return this.m_nItemSize;
    }

    //caching view before binding.
    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemNumberTextView;
        TextView itemIndexTextView;
        // root view of the item in item.xml normally.
        public ItemViewHolder(final View itemView) {
            super(itemView);
            itemNumberTextView = (TextView) itemView.findViewById(R.id.tv_item_number);
            itemIndexTextView =(TextView) itemView.findViewById(R.id.tv_item_index_number);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
            mListItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    interface  ListItemClickListener {
        public void onItemClick(int itemPosition);
    }
}