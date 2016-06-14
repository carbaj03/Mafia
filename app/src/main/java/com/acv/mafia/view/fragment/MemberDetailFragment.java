package com.acv.mafia.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.acv.mafia.MafiaApplication;
import com.acv.mafia.MemberDetailContract;
import com.acv.mafia.MemberListContract;
import com.acv.mafia.R;
import com.acv.mafia.injection.module.MemberDetailFragmentModule;
import com.acv.mafia.injection.module.MemberListFragmentModule;
import com.acv.mafia.model.Member;
import com.acv.mafia.view.ItemClickListener;
import com.acv.mafia.view.activity.MemberDetailActivity;
import com.acv.mafia.view.adapter.MemberAdapter;
import com.acv.mafia.view.adapter.MemberLayoutManager;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MemberDetailFragment extends BaseFragment implements MemberDetailContract.View, ItemClickListener{

    public static final String TAG = MemberDetailFragment.class.getSimpleName();

    @Inject MemberDetailContract.Presenter presenter;

    @BindView(R.id.tv_alias) TextView tvAlias;
    @BindView(R.id.tv_rank) TextView tvRank;
    @BindView(R.id.tv_description) TextView tvRankDescription;

    public static MemberDetailFragment newInstance() {
        return new MemberDetailFragment();
    }

    @Override
    protected void setupActivityComponent() {
        MafiaApplication.get(getActivity()).getMemberComponent()
                .plus(new MemberDetailFragmentModule(this)).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_member_detail, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadMember();
    }

    @Override
    public void renderMember(Member member) {
        if (member != null) {
            ((MemberDetailActivity)getActivity()).setTitle(member.getName());
            tvAlias.setText(member.getAlias());
            tvRank.setText(member.getRank().getLevelToString());
            tvRankDescription.setText(member.getRank().getDescription());
        }
    }

    @Override
    public void renderBoss(Member member) {

    }

    @Override
    public void renderSubordinates(List<Member> merbers) {

    }

    @Override
    public void onItemClick(View view, int position) {
    }
}
