package com.acv.mafia.model;

public class Rank {

    private String name;
    private String description;
    private int level;

    public Rank(String name, String description, int level) {
        this.name = name;
        this.description = description;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public String getLevelToString() {
        return String.valueOf(level);
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
