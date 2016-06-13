package com.acv.mafia.injection.component;

import com.acv.mafia.injection.module.MemberDetailFragmentModule;
import com.acv.mafia.injection.module.MemberListFragmentModule;
import com.acv.mafia.injection.module.MemberModule;
import com.acv.mafia.injection.scope.MemberScope;
import com.acv.mafia.view.fragment.MemberListFragment;

import javax.inject.Singleton;

import dagger.Subcomponent;

@MemberScope @Subcomponent(modules = MemberModule.class)
public interface MemberComponent {
    MemberListFragmentComponent plus(MemberListFragmentModule memberListFragmentModule);
    MemberDetailFragmentComponent plus(MemberDetailFragmentModule memberDetailFragmentModule);
}
