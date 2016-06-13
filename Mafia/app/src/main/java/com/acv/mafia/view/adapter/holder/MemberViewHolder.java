package com.acv.mafia.view.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.acv.mafia.R;
import com.acv.mafia.model.Member;
import com.acv.mafia.view.ItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MemberViewHolder extends ViewHolderBase {

    private static final String TAG = MemberViewHolder.class.getSimpleName();

    @BindView(R.id.tv_name) TextView tvName;

    public MemberViewHolder(Context context, View itemView, ItemClickListener itemClickListener) {
        super(context, itemView, itemClickListener);
        ButterKnife.bind(this, itemView);
    }

    public void render(Member member) {
        tvName.setText(member.getName());
    }
}