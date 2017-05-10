package com.surcharges.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mtzadmin on 10.05.2017.
 */
public class ShortNsiServiceImpl implements ShortNsiService{
    private Map<ShortNsiKind, List<String>> nsi;

    public ShortNsiServiceImpl() {
        this.fillMap();
    }

    private void fillMap(){
        nsi = new HashMap<>();
        nsi.put(ShortNsiKind.ACCOUNT, this.fillAccounts());
        nsi.put(ShortNsiKind.DENIAL_KIND, this.fillDenialKinds());
        nsi.put(ShortNsiKind.PAYMENT_DOC_KIND, this.fillPaymentDocumentKinds());
        nsi.put(ShortNsiKind.SURCHARGE_KIND, this.fillSurchargeKinds());
    }

    private List<String> fillAccounts(){
        ArrayList<String> accounts = new ArrayList<>();
        accounts.add("3320");
        accounts.add("3890");
        accounts.add("9753");
        return accounts;
    }

    private List<String> fillDenialKinds(){
        ArrayList<String> denialKinds = new ArrayList<>();
        denialKinds.add("пассажиры");
        denialKinds.add("багаж");
        denialKinds.add("протест ДС");
        denialKinds.add("разные сборы");
        denialKinds.add("пассажирские");
        denialKinds.add("кассовый отчет");
        denialKinds.add("недоборы нфдб");
        denialKinds.add("возврат");
        return  denialKinds;
    }

    private List<String> fillPaymentDocumentKinds(){
        ArrayList<String> docKinds = new ArrayList<>();
        docKinds.add("требование");
        docKinds.add("авизо");
        docKinds.add("акт");
        return docKinds;
    }

    private List<String> fillSurchargeKinds(){
        ArrayList<String> sKinds = new ArrayList<>();
        sKinds.add("свод 1");
        sKinds.add("багаж");
        sKinds.add("снято по ж/о 3");
        sKinds.add("возврат");
        sKinds.add("по акту ДН");
        sKinds.add("ведомость с доходов");
        return sKinds;
    }

    @Override
    public List<String> get(ShortNsiKind nsiKind) {
        return nsi.get(nsiKind);
    }
}
