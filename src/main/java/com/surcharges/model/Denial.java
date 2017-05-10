package com.surcharges.model;

import com.surcharges.service.IdGenerator;

import java.time.LocalDate;

/**
 * Created by Dreamer on 08.05.2017.
 */
public class Denial {
    private String id;
    private LocalDate date;
    private String kind;
    private String period;

    private IdGenerator idGenerator;

    public Denial(LocalDate date, String kind) {
        this.date = date;
        this.kind = kind;

        this.id = idGenerator.generateId();
        this.period = String.format("%02d%d", date.getMonthValue(), date.getYear());
    }

    public LocalDate getDate() {
        return date;
    }

    public String getKind() {
        return kind;
    }

    public String getPeriod() {
        return period;
    }
}
