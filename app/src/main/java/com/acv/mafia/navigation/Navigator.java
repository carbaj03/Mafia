package com.acv.mafia.navigation;

import android.app.Activity;

import com.acv.mafia.view.activity.HomeActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Navigator {

    @Inject public Navigator() {}

    public void navigateToUserList(Activity activity) {
        if (activity != null) {
            HomeActivity.launch(activity);
        }
    }
}
