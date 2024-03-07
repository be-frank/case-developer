package com.befrank.casedeveloperjava.application;

import com.befrank.casedeveloperjava.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WaardeberekeningService {

    private final DienstverbandRepository dienstverbandRepository;

    public Double berekenVerwachteWaarde(final Deelnemer deelnemer, final Integer gewenstePensioenleeftijd) {
        final Dienstverband dienstverband = dienstverbandRepository.findByDeelnemer(deelnemer)
                .orElseThrow(() -> new IllegalArgumentException("Geen dienstverband gevonden."));

        final double jaarlijksePremieStorting = dienstverband.jaarlijksePremie();

        // TODO Get from externe beleggingservice
        final double huidigeWaardeBeleggingen = 100_000.00;

        double verwachteWaarde = huidigeWaardeBeleggingen;
        for (int i = deelnemer.getLeeftijd(); i < gewenstePensioenleeftijd; i++) {
            verwachteWaarde = verwachteWaarde(verwachteWaarde, jaarlijksePremieStorting);
        }

        return Math.floor(verwachteWaarde * 100) / 100;
    }

    private double verwachteWaarde(double huidigeWaarde, double jaarlijksePremieStorting) {
        final double jaarlijksRendementBeleggingen = 3.0;
        return huidigeWaarde + jaarlijksePremieStorting + (huidigeWaarde + (jaarlijksePremieStorting/2)) * (jaarlijksRendementBeleggingen/100);
    }

}
