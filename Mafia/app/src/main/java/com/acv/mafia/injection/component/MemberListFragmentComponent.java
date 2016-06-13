package com.acv.mafia.injection.component;

import com.acv.mafia.injection.module.MemberListFragmentModule;
import com.acv.mafia.injection.scope.FragmentScope;
import com.acv.mafia.view.fragment.MemberListFragment;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = MemberListFragmentModule.class)
public interface MemberListFragmentComponent {
    MemberListFragment inject(MemberListFragment memberListFragment);
}
