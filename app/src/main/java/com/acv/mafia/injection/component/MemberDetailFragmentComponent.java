package com.acv.mafia.injection.component;

import com.acv.mafia.injection.module.MemberDetailFragmentModule;
import com.acv.mafia.injection.scope.FragmentScope;
import com.acv.mafia.view.fragment.MemberDetailFragment;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = MemberDetailFragmentModule.class)
public interface MemberDetailFragmentComponent {
    MemberDetailFragment inject(MemberDetailFragment memberDeatilFragment);
}
