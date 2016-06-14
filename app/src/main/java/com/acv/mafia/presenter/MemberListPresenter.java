/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acv.mafia.presenter;

import com.acv.mafia.MemberListContract;
import com.acv.mafia.domain.exception.DefaultErrorBundle;
import com.acv.mafia.domain.exception.ErrorBundle;
import com.acv.mafia.domain.exception.ErrorMessageFactory;
import com.acv.mafia.domain.interactor.DefaultSubscriber;
import com.acv.mafia.domain.interactor.UseCase;
import com.acv.mafia.model.Member;

import java.util.List;

public class MemberListPresenter implements MemberListContract.Presenter {

    private MemberListContract.View view;
    private final UseCase getMemberListUseCase;

    public MemberListPresenter(UseCase getMemberListUserCase, MemberListContract.View view) {
        this.getMemberListUseCase = getMemberListUserCase;
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
        this.getMemberListUseCase.unsubscribe();
        this.view = null;
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(view.context(), errorBundle.getException());
        view.showError(errorMessage);
    }

    @Override
    public void loadMembers() {
        view.hideRetry();
        view.showLoading();
        getMemberList();
    }

    private void getMemberList() {
        getMemberListUseCase.execute(new UserListSubscriber());
    }

    private final class UserListSubscriber extends DefaultSubscriber<List<Member>> {

        @Override
        public void onCompleted() {
            view.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            view.hideLoading();
            showErrorMessage(new DefaultErrorBundle((Exception) e));
            view.showRetry();
        }

        @Override
        public void onNext(List<Member> members) {
            view.renderMemberList(members);
        }
    }
}
