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
package com.acv.mafia.domain.interactor;

import com.acv.mafia.domain.executor.PostExecutionThread;
import com.acv.mafia.domain.executor.ThreadExecutor;
import com.acv.mafia.repository.MafiaDataSource;

import rx.Observable;

public class GetMemberList extends UseCase {

    private final MafiaDataSource mafiaDataSource;

    public GetMemberList(MafiaDataSource mafiaDataSource,
                         PostExecutionThread postExecutionThread) {
        super(postExecutionThread);
        this.mafiaDataSource = mafiaDataSource;
    }

    @Override
    public Observable buildUseCaseObservable() {
        return mafiaDataSource.getMembers();
    }
}
