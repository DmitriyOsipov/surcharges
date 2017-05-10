package com.surcharges.repository;

import com.surcharges.model.Surcharge;

public interface SurchargeRepository {

    void save(Surcharge surcharge);

    void update(Surcharge surcharge);

    Surcharge delete(String id);

    Surcharge find(String id);
}
