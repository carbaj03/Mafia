package com.acv.mafia.injection.component;

import com.acv.mafia.injection.module.MemberDetailActivityModule;
import com.acv.mafia.injection.scope.ActivityScope;
import com.acv.mafia.view.activity.MemberDetailActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = MemberDetailActivityModule.class)
public interface MemberDetailActivityComponent {
    MemberDetailActivity inject(MemberDetailActivity memberDetailActivity);
}
