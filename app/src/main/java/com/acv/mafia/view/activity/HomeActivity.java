package com.acv.mafia.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.acv.mafia.MafiaApplication;
import com.acv.mafia.R;
import com.acv.mafia.injection.module.HomeActivityModule;
import com.acv.mafia.navigation.Navigator;
import com.acv.mafia.view.ItemClickListener;
import com.acv.mafia.view.fragment.MemberListFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;

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
        if (savedInstanceState == null) {
            addFragment(R.id.container, MemberListFragment.newInstance());
        }
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
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
