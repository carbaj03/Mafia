package com.acv.mafia.repository;


import com.acv.mafia.model.Member;

import java.util.List;

import io.realm.Realm;
import rx.Observable;

public class LocalDataSource implements MafiaDataSource {

    private Realm realm;

    public LocalDataSource(Realm realm) {
        this.realm = realm;
    }

    @Override
    public Observable<List<Member>> getMembers() {
        return null;
    }

    @Override
    public Observable<Member> getMember(int userId) {
        return null;
    }
}
