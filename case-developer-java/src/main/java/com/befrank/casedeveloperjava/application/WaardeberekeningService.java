package com.befrank.casedeveloperjava.application;

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

    public double berekenVerwachteWaarde(final Deelnemer deelnemer, final Integer gewenstePensioenleeftijd) {
        final var dienstverband = dienstverbandRepository
                .findByDeelnemer(deelnemer)
                .orElseThrow(() -> new IllegalArgumentException("Geen dienstverband gevonden."));

        final double jaarlijksePremieStorting = dienstverband.jaarlijksePremie();
        final int jarenTotPensioen = gewenstePensioenleeftijd - deelnemer.getLeeftijd();

        final var beleggingsrekening = beleggingsserviceProxy.getBelegginsrekening(dienstverband.getPensioenrekening().rekeningnummer());

        return beleggingsrekening.prognose(jarenTotPensioen, jaarlijksePremieStorting);
    }
}
