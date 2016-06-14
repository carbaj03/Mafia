package com.acv.mafia.view.adapter.holder;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.acv.mafia.view.ItemClickListener;

abstract public class ViewHolderBase extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected Context context;
    private ItemClickListener itemClickListener;

    public ViewHolderBase(Context context, View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.context = context;
        this.itemClickListener = itemClickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(itemClickListener != null)
            itemClickListener.onItemClick(view, getAdapterPosition());
    }
}
