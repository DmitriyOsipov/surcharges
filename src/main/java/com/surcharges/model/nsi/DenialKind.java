package com.surcharges.model.nsi;

/**
 * Тип отказа. Причина, по которой отказано в оплате начета.
 */
public class DenialKind {
    private int id;
    private String name;

    public DenialKind(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
