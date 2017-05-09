package com.surcharges.model;

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

    public void addPayment(LocalDate date, double sum){
        this.payments.add(new Payment(date, sum));
    }


    private class Payment {
        private String id;
        private LocalDate date;
        private BigDecimal amount;

        Payment(LocalDate date, double amount) {
            this.date = date;
            this.amount = BigDecimal.valueOf(amount);
        }

        LocalDate getDate() {
            return date;
        }

        BigDecimal getAmount() {
            return amount;
        }
    }
}
