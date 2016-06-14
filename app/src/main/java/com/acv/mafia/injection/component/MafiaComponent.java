package com.acv.mafia.injection.component;

import com.acv.mafia.injection.module.HomeActivityModule;
import com.acv.mafia.injection.module.MafiaModule;
import com.acv.mafia.injection.module.MemberDetailActivityModule;
import com.acv.mafia.injection.module.MemberModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        MafiaModule.class
})
public interface MafiaComponent {
    HomeActivityComponent plus(HomeActivityModule homeActivityModule);
    MemberDetailActivityComponent plus(MemberDetailActivityModule memberDetailActivityModule);

    MemberComponent plus(MemberModule memberModule);
}
