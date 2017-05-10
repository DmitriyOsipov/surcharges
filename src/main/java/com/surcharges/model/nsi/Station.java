package com.surcharges.model.nsi;

/**
 * Железнодорожная станция.
 * Содержит поля:
 *      код станции,
 *      название станции,
 *      дирекция,
 *      статус блокировки (в случае, если станция ликвидирована)
 */

public class Station {
    private int id;
    private String name;
    private Direction direction;
    private boolean blocked;

    public Station(int id, String name, Direction direction, boolean blocked) {
        this.id = id;
        this.name = name;
        this.direction = direction;
        this.blocked = blocked;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
