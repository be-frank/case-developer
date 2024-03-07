package com.befrank.casedeveloperjava.domain.beleggingen;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Beleggingsrekening {

    private final String rekeningnummer;

    private Set<Beleggingsfonds> beleggingsfondsen = new HashSet<>();

    public double totaleWaarde() {
        // De totale waarde van de beleggingsrekening is de som van de waarde in de fondsen.
        // Voor nu hardcoded
        return 100_000;
    }

    public double jaarlijksRendementBeleggingen() {
        // Voor nu hardcoded
        return 3.0;
    }

    public double prognose(final int jarenTotPensioen, final double jaarlijksePremieStorting) {
        double waarde = totaleWaarde();
        for (int i = 0; i < jarenTotPensioen; i++) {
            waarde = waarde + jaarlijksePremieStorting + (waarde + (jaarlijksePremieStorting / 2)) * (jaarlijksRendementBeleggingen() / 100);
        }
        return Math.floor(waarde * 100) / 100;
    }
}
