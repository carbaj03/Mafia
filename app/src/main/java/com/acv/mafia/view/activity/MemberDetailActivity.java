package com.acv.mafia.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.Toast;

import com.acv.mafia.MafiaApplication;
import com.acv.mafia.R;
import com.acv.mafia.injection.module.HomeActivityModule;
import com.acv.mafia.injection.module.MemberDetailActivityModule;
import com.acv.mafia.view.fragment.MemberDetailFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MemberDetailActivity extends BaseActivity  {

    private static final String EXTRA_MEMBER_ID = "MEMBER_ID";

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;

    private int memberId;

    public static void launch(Activity activity, int memberId) {
        activity.startActivity(newInstance(activity, memberId));
    }

    public static Intent newInstance(Context context, int memberId) {
        Intent intent = new Intent(context, MemberDetailActivity.class);
        intent.putExtra(EXTRA_MEMBER_ID, memberId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configToolbar();
        if (savedInstanceState == null) {
            addFragment(R.id.container, MemberDetailFragment.newInstance());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.putInt(EXTRA_MEMBER_ID, memberId);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            memberId = getIntent().getIntExtra(EXTRA_MEMBER_ID, -1);
            addFragment(R.id.container, MemberDetailFragment.newInstance());
        } else {
            memberId = savedInstanceState.getInt(EXTRA_MEMBER_ID);
        }
    }

    @Override
    protected void bindViews() {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void setupActivityComponent() {
        MafiaApplication.get(this).getComponent()
                .plus(new MemberDetailActivityModule(this))
                .inject(this);
        MafiaApplication.get(this).createMemberComponent(memberId);
    }

    private void configToolbar() {
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public void setTitle(String title){
        toolbar.setTitle(title);
    }

    @OnClick(R.id.fab)
    public void onClickFab(){
        Toast.makeText(this, "Add subordinate", Toast.LENGTH_SHORT).show();
    }
}
