package com.surcharges.model;

import com.surcharges.service.IdGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dreamer on 09.05.2017.
 */
public class PaymentsList {
    List<Payment> payments;

    public PaymentsList() {
        payments = new ArrayList<>();
    }

    public BigDecimal getTotal(){
        BigDecimal amount = BigDecimal.ZERO;
        for (Payment payment: payments){
            amount.add(payment.getAmount());
        }

        return amount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addPayment(LocalDate date, double sum, String documentKind, int documentNumber){
        this.payments.add(new Payment(date, sum, documentKind, documentNumber));
    }


    public class Payment {
        private String id;
        private LocalDate date;
        private BigDecimal amount;
        private String documentKind;
        private int documentNumber;
        private String period;

        private IdGenerator idGenerator;

        Payment(LocalDate date, double amount) {
            this.date = date;
            this.amount = BigDecimal.valueOf(amount);

            this.period = String.format("%02d%d", date.getMonthValue(), date.getYear());
            this.id = idGenerator.generateId();

            this.documentKind = "";
            this.documentNumber = 0;
        }

        public Payment(LocalDate date, double amount, String documentKind, int documentNumber) {
            this(date, amount);
            this.documentKind = documentKind;
            this.documentNumber = documentNumber;
        }

        LocalDate getDate() {
            return date;
        }

        BigDecimal getAmount() {
            return amount;
        }

        public String getDocumentKind() {
            return documentKind;
        }

        public int getDocumentNumber() {
            return documentNumber;
        }

        public String getPeriod() {
            return period;
        }

        public void setDocumentKind(String documentKind) {
            this.documentKind = documentKind;
        }

        public void setDocumentNumber(int documentNumber) {
            this.documentNumber = documentNumber;
        }

        public void setIdGenerator(IdGenerator idGenerator) {
            this.idGenerator = idGenerator;
        }
    }
}
