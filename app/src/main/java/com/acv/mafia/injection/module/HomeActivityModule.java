package com.acv.mafia.injection.module;

import android.support.v4.app.FragmentManager;

import com.acv.mafia.injection.scope.ActivityScope;
import com.acv.mafia.view.activity.HomeActivity;
import com.acv.mafia.view.adapter.PagerAdapter;

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

    @Provides @ActivityScope
    FragmentManager provideFragmentManager(){
        return homeActivity.getSupportFragmentManager();
    }

    @Provides @ActivityScope
    PagerAdapter providePagerAdapter(FragmentManager fragmentManager){
        return new PagerAdapter(fragmentManager);
    }
}
