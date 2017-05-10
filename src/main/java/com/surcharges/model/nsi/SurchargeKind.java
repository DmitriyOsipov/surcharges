package com.surcharges.model.nsi;

/**
 * Тип начета
 */
public class SurchargeKind {
    private int id;
    private String name;

    public SurchargeKind(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
