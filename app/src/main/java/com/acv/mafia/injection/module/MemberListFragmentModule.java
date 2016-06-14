package com.acv.mafia.injection.module;

import com.acv.mafia.MemberListContract;
import com.acv.mafia.domain.interactor.UseCase;
import com.acv.mafia.injection.scope.FragmentScope;
import com.acv.mafia.presenter.MemberListPresenter;
import com.acv.mafia.view.adapter.MemberAdapter;
import com.acv.mafia.view.fragment.MemberListFragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MemberListFragmentModule {

    MemberListFragment memberListFragment;

    public MemberListFragmentModule(MemberListFragment memberListFragment) {
        this.memberListFragment = memberListFragment;
    }

    @Provides @FragmentScope
    public MemberListFragment provideMemberListFragment() {
        return memberListFragment;
    }

    @Provides @FragmentScope
    MemberAdapter provideMemberAdapter(){
        return new MemberAdapter(memberListFragment.getActivity());
    }

    @Provides @FragmentScope
    MemberListContract.Presenter providePreseneter(@Named("memberList") UseCase getMemberListUserCase){
        return new MemberListPresenter(getMemberListUserCase, memberListFragment);
    }
}
