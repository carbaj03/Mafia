package com.acv.mafia.repository;

import com.acv.mafia.model.Member;

import java.util.List;

import rx.Observable;

public interface MafiaDataSource {

    Observable<List<Member>> getMembers();

    Observable<Member> getMember(int userId);
}
