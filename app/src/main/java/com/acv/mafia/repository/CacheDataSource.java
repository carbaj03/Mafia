package com.acv.mafia.repository;


import com.acv.mafia.model.Member;
import com.acv.mafia.model.Rank;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import io.realm.Realm;
import rx.Observable;
import rx.functions.Func1;

public class CacheDataSource implements MafiaDataSource {

    private List<Member> members = new ArrayList<>();

    public CacheDataSource() {
        createMembers();
    }

    private List<Member> createMembers() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1985, 1, 1);

        Rank rank = new Rank("Boss", "Boss of all", 1);
        members.add(new Member(1,"Name Boss", "Alias Boss", rank, false, calendar.getTime()));

        rank = new Rank("UnderBoss", "Underboss description", 2);
        for (int underBoss = 2; underBoss <= 5; underBoss++)
            members.add(new Member(
                    underBoss,
                    "Name Underboss " + (underBoss - 1),
                    "Alias Underboss " + (underBoss - 1),
                    rank,
                    false,
                    getDate(1990, 2000).getTime()));

        rank = new Rank("Caporegime", "Caporegime description", 3);
        for (int caporegime = 6; caporegime <= 15; caporegime++)
            members.add(new Member(
                    caporegime,
                    "Name Caporegime " + (caporegime - 1),
                    "Alias Caporegime " + (caporegime - 1),
                    rank,
                    false,
                    getDate(2001, 2010).getTime()));

        rank = new Rank("Soldier", "Soldier description", 3);
        for (int soldier = 15; soldier <= 40; soldier++)
            members.add(new Member(
                    soldier,
                    "Name Soldier " + (soldier - 1),
                    "Alias Soldier " + (soldier - 1),
                    rank,
                    false,
                    getDate(2010, 2016).getTime()));
        return members;
    }

    public Calendar getDate(int start, int end) {

        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(start, end);
        gc.set(GregorianCalendar.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));
        gc.set(GregorianCalendar.DAY_OF_YEAR, dayOfYear);
        return gc;
    }

    public int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    @Override
    public Observable<List<Member>> getMembers() {
        return Observable.from(members).toList();
    }

    @Override
    public Observable<Member> getMember(int memberId) {
        return Observable.from(members)
                .filter(member -> member.getId() == memberId);
    }
}
