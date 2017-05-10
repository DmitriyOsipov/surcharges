package com.surcharges.service;

import com.surcharges.model.Surcharge;

import java.time.LocalDate;
import java.util.List;

public interface SurchargeService {
    Surcharge createSurcharge(LocalDate date, int stationId, String kind, int number, int account, double sum);

    List<Surcharge> findSurcharges(String period);
    List<Surcharge> findSurcharges(String period, int stationId);

    List<Surcharge> findAll();
}
