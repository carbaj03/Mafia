package com.acv.mafia.injection.module;

import com.acv.mafia.injection.scope.ActivityScope;
import com.acv.mafia.view.activity.HomeActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeActivityModule {

    HomeActivity homeActivity;

    public HomeActivityModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Provides @ActivityScope
    public HomeActivity provideHomeActivity() {
        return homeActivity;
    }
}
