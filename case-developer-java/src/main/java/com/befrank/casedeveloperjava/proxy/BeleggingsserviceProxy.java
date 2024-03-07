package com.befrank.casedeveloperjava.proxy;

import com.befrank.casedeveloperjava.domain.beleggingen.Beleggingsrekening;
import org.springframework.stereotype.Component;

@Component
public class BeleggingsserviceProxy {

    public Beleggingsrekening getBelegginsrekening(final String rekeningnummer) {
        // Hier zou normaalgesproken een externe API aangeroepen worden om de beleggingsrekening op te halen.
        // Voor nu geven we een dummy object terug.
        return new Beleggingsrekening(rekeningnummer);
    }
}
