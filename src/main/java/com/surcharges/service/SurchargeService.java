package com.surcharges.service;

import com.surcharges.model.Surcharge;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Dreamer on 09.05.2017.
 */
public interface SurchargeService {
    Surcharge createSurcharge(LocalDate date, int stationId, String kind, int number, int account, double sum);

    List<Surcharge> findSurcharges(String period);
    List<Surcharge> findSurcharges(String period, int stationId);

    List<Surcharge> findAll();
}
