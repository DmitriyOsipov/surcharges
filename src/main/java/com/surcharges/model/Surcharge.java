package com.surcharges.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dreamer on 08.05.2017.
 */
public class Surcharge {
    private String id;
    private LocalDateTime date;
    private int stationId;
    private String kind;
    private int number;
    private int account;
    private List<Payment> payments;
    private Refusing refusing;
    private String comment;
    private String period;
    private SurchargeStatus status;

    public Surcharge(String id, LocalDateTime date, int stationId, String kind, int number, int account) {
        this.id = id;
        this.date = date;
        this.stationId = stationId;
        this.kind = kind;
        this.number = number;
        this.account = account;

        this.period = String.format("%d%d", date.getMonth().getValue(), date.getYear());
        this.status = SurchargeStatus.IN_ACTION;
        payments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getStationId() {
        return stationId;
    }

    public String getKind() {
        return kind;
    }

    public int getNumber() {
        return number;
    }

    public int getAccount() {
        return account;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public Refusing getRefusing() {
        return refusing;
    }

    public String getComment() {
        return comment;
    }

    public String getPeriod() {
        return period;
    }

    public SurchargeStatus getStatus() {
        return status;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void addPayment(Payment payment) {
        if (this.status == SurchargeStatus.IN_ACTION) {
            this.payments.add(payment);
        }
    }

    public void setRefusing(Refusing refusing) {
        if (this.status == SurchargeStatus.IN_ACTION)
        this.refusing = refusing;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setStatus(SurchargeStatus status) {
        this.status = status;
    }
}
