package com.surcharges.repository;

import com.surcharges.model.Surcharge;

import java.util.Map;

public class MemorySurchargeRepository implements SurchargeRepository {
    Map<String, Surcharge> surcharges;

    @Override
    public void save(Surcharge surcharge) {
        surcharges.put(surcharge.getId(), surcharge);
    }

    @Override
    public void update(Surcharge surcharge) {
        this.save(surcharge);
    }

    @Override
    public Surcharge delete(String id) {
        return surcharges.remove(id);
    }

    @Override
    public Surcharge find(String id) {
        return surcharges.get(id);
    }
}
