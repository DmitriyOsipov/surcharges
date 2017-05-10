package com.surcharges.service;

import java.util.List;

public interface ShortNsiService {
    enum ShortNsiKind {ACCOUNT, DENIAL_KIND, PAYMENT_DOC_KIND, SURCHARGE_KIND};
    List<String> get(ShortNsiKind nsiKind);
}
