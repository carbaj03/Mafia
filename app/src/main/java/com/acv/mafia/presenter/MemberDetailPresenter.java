package com.acv.mafia.presenter;

import com.acv.mafia.MemberDetailContract;
import com.acv.mafia.MemberListContract;
import com.acv.mafia.domain.exception.DefaultErrorBundle;
import com.acv.mafia.domain.exception.ErrorBundle;
import com.acv.mafia.domain.exception.ErrorMessageFactory;
import com.acv.mafia.domain.interactor.DefaultSubscriber;
import com.acv.mafia.domain.interactor.UseCase;
import com.acv.mafia.model.Member;

import java.util.List;

public class MemberDetailPresenter implements MemberDetailContract.Presenter {

    private MemberDetailContract.View view;
    private final UseCase getMemberDetailUseCase;

    public MemberDetailPresenter(UseCase getMemberDetailUserCase, MemberDetailContract.View view) {
        this.getMemberDetailUseCase = getMemberDetailUserCase;
        this.view = view;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void destroy() {
        this.getMemberDetailUseCase.unsubscribe();
        this.view = null;
    }

    @Override
    public void loadMember() {
        getMember();
    }

    @Override
    public void loadSubordinates() {

    }

    private void getMember() {
        getMemberDetailUseCase.execute(new UserDetailSubscriber());
    }

    @Override
    public void loadBoss() {

    }

    private final class UserDetailSubscriber extends DefaultSubscriber<Member> {

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Member member) {
            view.renderMember(member);
        }
    }
}
