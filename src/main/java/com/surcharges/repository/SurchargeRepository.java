package com.surcharges.repository;

import com.surcharges.model.Surcharge;

/**
 * Created by Dreamer on 08.05.2017.
 */
public interface SurchargeRepository {

    void save(Surcharge surcharge);

    void update(Surcharge surcharge);

    Surcharge delete(String id);

    Surcharge find(String id);
}
