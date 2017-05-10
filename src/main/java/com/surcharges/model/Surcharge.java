package com.surcharges.model;

import com.surcharges.model.nsi.Account;
import com.surcharges.model.nsi.Station;
import com.surcharges.model.nsi.SurchargeKind;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Начет. Содержит поля:
 *      ид
 *      станция, по которой сформирован начет
 *      дата начета
 *      тип начета
 *      номер начета
 *      сумма начета
 *      номер счета
 *      комментарий (примечание)
 *      период начета (месяц и год)
 *      статус
 *      список проплат
 *      отказ
 */
public class Surcharge {
    private String id;
    private Station station;
    private LocalDate date;
    private SurchargeKind kind;
    private int number;
    private BigDecimal sum;
    private Account account;
    private String comment;
    private String period;
    private SurchargeStatus status;
    private PaymentsList payments;
    private Denial denial;

    /*
    private User author;
    private User editor;
    private LocalDateTime editTime;
    //*/

    public Surcharge(String id, LocalDate date, Station station, SurchargeKind kind, int number, Account account, double sum) {
        this.id = id;
        this.date = date;
        this.station = station;
        this.kind = kind;
        this.number = number;
        this.account = account;

        this.sum = BigDecimal.valueOf(sum);
        this.period = String.format("%02d%d", date.getMonth().getValue(), date.getYear());
        this.status = SurchargeStatus.IN_ACTION;
        payments = new PaymentsList();
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Station getStation() {
        return station;
    }

    public SurchargeKind getKind() {
        return kind;
    }

    public int getNumber() {
        return number;
    }

    public Account getAccount() {
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

    public void setKind(SurchargeKind kind) {
        this.kind = kind;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    private BigDecimal getUnpaidSum(){
        BigDecimal payed = payments.getTotal();
        return this.sum.subtract(payed);
    }

    private boolean isPaid(){
        double threshold = 0.00001;
        return ((this.status == SurchargeStatus.PAID)||
                (this.getUnpaidSum().compareTo(BigDecimal.valueOf(threshold))<0));
    }

    private boolean canBePaid(double sum){
       return ((this.status == SurchargeStatus.IN_ACTION)&&
               (this.getUnpaidSum().compareTo(BigDecimal.valueOf(sum)))>=0);
    }



    public void addPayment(LocalDate date, double sum, String documentKind, int documentNumber) {
        if (canBePaid(sum)) {
            this.payments.addPayment(date, sum, documentKind, documentNumber);
            if (isPaid()){
                this.setStatus(SurchargeStatus.PAID);
            }
        }
    }

    public void setDenial(Denial denial) {
        if (this.status == SurchargeStatus.IN_ACTION) {
            this.denial = denial;
            this.setStatus(SurchargeStatus.REFUSED);
        }
    }

    public void setDenial(LocalDate date, String denialKind) {
        this.setDenial(new Denial(date, denialKind));
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setStatus(SurchargeStatus status) {
        this.status = status;
    }


    public enum SurchargeStatus {
        IN_ACTION,
        PAID,
        REFUSED;
    }
}
