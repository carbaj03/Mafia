package com.acv.mafia.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.acv.mafia.MafiaApplication;
import com.acv.mafia.MemberListContract;
import com.acv.mafia.R;
import com.acv.mafia.injection.module.MemberListFragmentModule;
import com.acv.mafia.model.Member;
import com.acv.mafia.view.ItemClickListener;
import com.acv.mafia.view.activity.MemberDetailActivity;
import com.acv.mafia.view.adapter.MemberAdapter;
import com.acv.mafia.view.adapter.MemberLayoutManager;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MemberListFragment extends BaseFragment implements MemberListContract.View, ItemClickListener{

    public static final String TAG = MemberListFragment.class.getSimpleName();

    @Inject MemberAdapter memberAdapter;
    @Inject MemberListContract.Presenter presenter;

    @BindView(R.id.rl_progress) RelativeLayout rlProgress;
    @BindView(R.id.rl_retry) RelativeLayout rlRetry;
    @BindView(R.id.btn_retry) Button btnRetry;
    @BindView(R.id.rv_member) RecyclerView recyclerView;

    public static MemberListFragment newInstance() {
        return new MemberListFragment();
    }

    @Override
    protected void setupActivityComponent() {
        MafiaApplication.get(getActivity()).getMemberComponent()
                .plus(new MemberListFragmentModule(this)).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_member_list, container, false);
        ButterKnife.bind(this, rootView);
        setupRecyclerView();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadMembers();
    }

    private void setupRecyclerView() {
        memberAdapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new MemberLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(memberAdapter);
    }

    @Override public void showLoading() {
        this.rlProgress.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override public void hideLoading() {
        this.rlProgress.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetry() {
        this.rlRetry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.rlRetry.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void renderMemberList(Collection<Member> members) {
        memberAdapter.addAll(members);
    }

    @OnClick(R.id.btn_retry)
    void onButtonRetryClick() {
    }

    @Override
    public void onItemClick(View view, int position) {
        MemberDetailActivity.launch(getActivity(), memberAdapter.getItem(position).getId());
    }
}
