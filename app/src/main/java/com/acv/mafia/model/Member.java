package com.acv.mafia.model;


import java.util.Date;

public class Member {

    private int id;
    private String name;
    private String alias;
    private Rank rank;
    private boolean imprisioned;
    private Date recluted;

    public Member(int id, String name, String alias, Rank rank, boolean imprisioned, Date recluted) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.rank = rank;
        this.imprisioned = imprisioned;
        this.recluted = recluted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public boolean isImprisioned() {
        return imprisioned;
    }

    public void setImprisioned(boolean imprisioned) {
        this.imprisioned = imprisioned;
    }

    public Date getRecluted() {
        return recluted;
    }

    public void setRecluted(Date recluted) {
        this.recluted = recluted;
    }
}
