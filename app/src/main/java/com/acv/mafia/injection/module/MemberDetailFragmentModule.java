package com.acv.mafia.injection.module;

import com.acv.mafia.MemberDetailContract;
import com.acv.mafia.domain.interactor.UseCase;
import com.acv.mafia.injection.scope.FragmentScope;
import com.acv.mafia.presenter.MemberDetailPresenter;
import com.acv.mafia.view.adapter.MemberAdapter;
import com.acv.mafia.view.fragment.MemberDetailFragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MemberDetailFragmentModule {

    private MemberDetailFragment memberDetailFragment;

    public MemberDetailFragmentModule(MemberDetailFragment memberDetailFragment) {
        this.memberDetailFragment = memberDetailFragment;
    }

    @Provides @FragmentScope
    public MemberDetailFragment provideMemberDetailFragment() {
        return memberDetailFragment;
    }


    @Provides @FragmentScope
    MemberDetailContract.Presenter providePreseneter(@Named("memberDetail") UseCase getMemberDetailUserCase){
        return new MemberDetailPresenter(getMemberDetailUserCase, memberDetailFragment);
    }
}
