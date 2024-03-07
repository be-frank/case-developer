package com.befrank.casedeveloperjava.application;

import com.befrank.casedeveloperjava.domain.beleggingen.Beleggingsrekening;
import com.befrank.casedeveloperjava.domain.deelnemer.Deelnemer;
import com.befrank.casedeveloperjava.domain.deelnemer.DienstverbandRepository;
import com.befrank.casedeveloperjava.proxy.BeleggingsserviceProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WaardeberekeningService {

    private final DienstverbandRepository dienstverbandRepository;
    private final BeleggingsserviceProxy beleggingsserviceProxy;

    public Double berekenVerwachteWaarde(final Deelnemer deelnemer, final Integer gewenstePensioenleeftijd) {
        final var dienstverband = dienstverbandRepository
                .findByDeelnemer(deelnemer)
                .orElseThrow(() -> new IllegalArgumentException("Geen dienstverband gevonden."));
        final double jaarlijksePremieStorting = dienstverband.jaarlijksePremie();
        final var beleggingsrekening = beleggingsserviceProxy.getBelegginsrekening(dienstverband.getPensioenrekening().rekeningnummer());
        final int jarenTotPensioen = gewenstePensioenleeftijd - deelnemer.getLeeftijd();

        return verwachteWaarde(jarenTotPensioen, beleggingsrekening, jaarlijksePremieStorting);
    }

    private Double verwachteWaarde(final int jarenTotPensioen, final Beleggingsrekening beleggingsrekening, final double jaarlijksePremieStorting) {
        double waarde = beleggingsrekening.totaleWaarde();
        for (int i = 0; i < jarenTotPensioen; i++) {
            waarde = waarde + jaarlijksePremieStorting + (waarde + (jaarlijksePremieStorting/2)) * (beleggingsrekening.jaarlijksRendementBeleggingen()/100);
        }
        return Math.floor(waarde * 100) / 100;
    }
}
