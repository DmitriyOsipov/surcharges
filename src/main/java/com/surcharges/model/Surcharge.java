package com.surcharges.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Dreamer on 08.05.2017.
 */
public class Surcharge {
    private String id;
    private LocalDate date;
    private int stationId;
    private String kind;
    private int number;
    private int account;
    private BigDecimal sum;
    private PaymentsList payments;
    private Denial denial;
    private String comment;
    private String period;
    private SurchargeStatus status;

    public Surcharge(String id, LocalDate date, int stationId, String kind, int number, int account, double sum) {
        this.id = id;
        this.date = date;
        this.stationId = stationId;
        this.kind = kind;
        this.number = number;
        this.account = account;

        this.sum = BigDecimal.valueOf(sum);
        this.period = String.format("%d%d", date.getMonth().getValue(), date.getYear());
        this.status = SurchargeStatus.IN_ACTION;
        payments = new PaymentsList();
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
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

    public Denial getDenial() {
        return denial;
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

    private BigDecimal getUnpaidSum(){
        BigDecimal payed = payments.getTotal();
        return this.sum.subtract(payed);
    }

    private boolean canBePaid(double sum){
       return ((this.status == SurchargeStatus.IN_ACTION)&&
               (this.getUnpaidSum().compareTo(BigDecimal.valueOf(sum)))>=0);
    }

    public void addPayment(LocalDate date, double sum, String documentKind, int documentNumber) {
        if (canBePaid(sum)) {
            this.payments.addPayment(date, sum, documentKind, documentNumber);
        }
    }

    public void setDenial(Denial denial) {
        if (this.status == SurchargeStatus.IN_ACTION)
        this.denial = denial;
    }

    public void setDenial(LocalDate date, String denialKind) {
        if (this.status == SurchargeStatus.IN_ACTION)
            this.denial = new Denial(date, denialKind);
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setStatus(SurchargeStatus status) {
        this.status = status;
    }


    public enum SurchargeStatus {
        IN_ACTION,
        PAYED,
        REFUSED;
    }
}
