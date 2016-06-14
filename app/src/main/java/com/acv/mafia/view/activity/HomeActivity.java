package com.acv.mafia.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.acv.mafia.MafiaApplication;
import com.acv.mafia.R;
import com.acv.mafia.injection.module.HomeActivityModule;
import com.acv.mafia.view.adapter.PagerAdapter;
import com.acv.mafia.view.fragment.MemberListFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @Inject PagerAdapter pagerAdapter;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.tabs) TabLayout tabLayout;
    @BindView(R.id.container) ViewPager viewPager;

    public static void launch(Activity activity) {
        activity.startActivity(newInstance(activity));
    }

    public static Intent newInstance(Context context) {
        return new Intent(context, HomeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configToolbar();
        setViewPager();
    }

    private void setViewPager(){
        pagerAdapter.addFragment(MemberListFragment.newInstance(), getString(R.string.members));
        pagerAdapter.addFragment(MemberListFragment.newInstance(), getString(R.string.highlight));
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {

    }

    @Override
    protected void bindViews() {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @Override
    protected void setupActivityComponent() {
        MafiaApplication.get(this).getComponent()
                .plus(new HomeActivityModule(this))
                .inject(this);
        MafiaApplication.get(this).createMemberComponent(0);
    }

    private void configToolbar() {
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
    }
}
