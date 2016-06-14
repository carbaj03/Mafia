package com.acv.mafia.injection.module;

import com.acv.mafia.injection.scope.ActivityScope;
import com.acv.mafia.view.activity.HomeActivity;
import com.acv.mafia.view.activity.MemberDetailActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MemberDetailActivityModule {

    MemberDetailActivity memberDetailActivity;

    public MemberDetailActivityModule(MemberDetailActivity memberDetailActivity) {
        this.memberDetailActivity = memberDetailActivity;
    }

    @Provides @ActivityScope
    public MemberDetailActivity provideMemberDetailActivity() {
        return memberDetailActivity;
    }
}
