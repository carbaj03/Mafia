package com.acv.mafia.injection.module;

import android.content.Context;

import com.acv.mafia.MafiaApplication;
import com.acv.mafia.UIThread;
import com.acv.mafia.domain.executor.PostExecutionThread;
import com.acv.mafia.domain.executor.ThreadExecutor;
import com.acv.mafia.domain.interactor.GetMemberDetail;
import com.acv.mafia.domain.interactor.GetMemberList;
import com.acv.mafia.domain.interactor.UseCase;
import com.acv.mafia.injection.scope.ActivityScope;
import com.acv.mafia.injection.scope.FragmentScope;
import com.acv.mafia.repository.CacheDataSource;
import com.acv.mafia.repository.MafiaDataSource;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.sql.DataSource;

import dagger.Module;
import dagger.Provides;

@Module
public class MafiaModule {

    private final MafiaApplication application;

    public MafiaModule(MafiaApplication application) {
        this.application = application;
    }

    @Provides @Singleton
    public Context getApplicationContext() {
        return application;
    }

    @Provides @Singleton
    PostExecutionThread proividePostExecutionThread(){
        return new UIThread();
    }

    @Provides @Singleton
    MafiaDataSource provideCacheDataSource(){
        return new CacheDataSource();
    }
}
