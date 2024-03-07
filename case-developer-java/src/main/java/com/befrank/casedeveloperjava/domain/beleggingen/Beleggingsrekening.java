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
}
