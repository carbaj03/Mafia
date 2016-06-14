package com.acv.mafia.injection.module;

import com.acv.mafia.domain.executor.PostExecutionThread;
import com.acv.mafia.domain.interactor.GetMemberDetail;
import com.acv.mafia.domain.interactor.GetMemberList;
import com.acv.mafia.domain.interactor.UseCase;
import com.acv.mafia.injection.scope.ActivityScope;
import com.acv.mafia.injection.scope.MemberScope;
import com.acv.mafia.repository.MafiaDataSource;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MemberModule {

    private int userId = -1;

    public MemberModule() {
    }

    public MemberModule(int userId) {
        this.userId = userId;
    }

    @Provides @ActivityScope @Named("memberList")
    UseCase provideGetMemberListUseCase(MafiaDataSource mafiaDataSource,
                                        PostExecutionThread postExecutionThread) {
        return new GetMemberList(mafiaDataSource, postExecutionThread);
    }

    @Provides @ActivityScope @Named("memberDetail")
    UseCase provideGetMemberDetailUseCase(MafiaDataSource mafiaDataSource,
                                          PostExecutionThread postExecutionThread) {
        return new GetMemberDetail(userId, mafiaDataSource, postExecutionThread);
    }
}