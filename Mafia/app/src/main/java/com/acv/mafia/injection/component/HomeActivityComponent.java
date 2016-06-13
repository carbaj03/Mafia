package com.acv.mafia.injection.component;

import com.acv.mafia.injection.module.HomeActivityModule;
import com.acv.mafia.injection.scope.ActivityScope;
import com.acv.mafia.view.activity.HomeActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = HomeActivityModule.class)
public interface HomeActivityComponent {
    HomeActivity inject(HomeActivity homeActivity);
}
