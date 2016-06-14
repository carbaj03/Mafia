package com.acv.mafia.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.acv.mafia.R;
import com.acv.mafia.model.Member;
import com.acv.mafia.view.adapter.holder.MemberViewHolder;

import java.util.Collection;

public class MemberAdapter extends AdapterListBase<Member> {

    private int layout = R.layout.member_row;

    public MemberAdapter(Activity activity) {
        super(activity);
    }

    @Override
    public Member getItem(int position) {
        return data.get(position);
    }

    public void addAll(Collection<Member> collection) {
        data.clear();
        for (int i = 0; i < collection.size(); i++) {
            data.add((Member) collection.toArray()[i]);
        }
    }

    public void add(Member goTMember){
        data.add(goTMember);
        notifyItemInserted(data.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MemberViewHolder(activity, inflate(parent, layout), itemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MemberViewHolder memberViewHolder = (MemberViewHolder) holder;
        memberViewHolder.render(data.get(position));
    }
}
