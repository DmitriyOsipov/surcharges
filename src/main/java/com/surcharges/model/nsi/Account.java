package com.surcharges.model.nsi;

/**
 * Счет, по которому идет начет.
 * Есть только одно поле - номер счета.
 */
public class Account {
    private int id;

    public Account(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return id;
    }
}
