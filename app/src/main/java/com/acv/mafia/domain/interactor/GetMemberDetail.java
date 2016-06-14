package com.acv.mafia.domain.interactor;

import com.acv.mafia.domain.executor.PostExecutionThread;
import com.acv.mafia.repository.MafiaDataSource;

import javax.inject.Inject;

import rx.Observable;

public class GetMemberDetail extends UseCase {

    private final int memberId;
    private final MafiaDataSource mafiaDataSource;

    @Inject
    public GetMemberDetail(int memberId, MafiaDataSource mafiaDataSource, PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.memberId = memberId;
        this.mafiaDataSource = mafiaDataSource;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mafiaDataSource.getMember(memberId);
    }
}
