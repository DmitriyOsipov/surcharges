package com.surcharges.service;

import java.util.UUID;

/**
 * Created by Dreamer on 09.05.2017.
 */
public class IdGeneratorImpl implements IdGenerator {
    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
