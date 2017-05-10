package com.surcharges.service;

import java.util.List;

/**
 * Created by mtzadmin on 10.05.2017.
 */
public interface ShortNsiService {
    enum ShortNsiKind {ACCOUNT, DENIAL_KIND, PAYMENT_DOC_KIND, SURCHARGE_KIND};
    List<String> get(ShortNsiKind nsiKind);
}
