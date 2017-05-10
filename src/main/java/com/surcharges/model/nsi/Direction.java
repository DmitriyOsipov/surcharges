package com.surcharges.model.nsi;

/**
 * Железнодорожная дирекция.
 */
public class Direction {
    private int id;
    private String name;

    public Direction(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
