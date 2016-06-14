package com.acv.mafia;

import android.app.Application;
import android.content.Context;

import com.acv.mafia.injection.component.DaggerMafiaComponent;
import com.acv.mafia.injection.component.MafiaComponent;
import com.acv.mafia.injection.component.MemberComponent;
import com.acv.mafia.injection.module.MafiaModule;
import com.acv.mafia.injection.module.MemberModule;

public class MafiaApplication extends Application {

    private MafiaComponent mafiaComponent;
    private MemberComponent memberComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }

    private void initAppComponent() {
        this.mafiaComponent = DaggerMafiaComponent.builder()
                .mafiaModule(new MafiaModule(this))
                .build();
    }

    public MemberComponent createMemberComponent(int memberId) {
        memberComponent = mafiaComponent.plus(new MemberModule(memberId));
        return memberComponent;
    }

    public MafiaComponent getComponent() {
        return mafiaComponent;
    }

    public MemberComponent getMemberComponent() {
        return memberComponent;
    }

    public static MafiaApplication get(Context context) {
        return (MafiaApplication) context.getApplicationContext();
    }
}
