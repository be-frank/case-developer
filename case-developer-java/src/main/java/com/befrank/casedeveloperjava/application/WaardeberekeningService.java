package com.befrank.casedeveloperjava.application;

import com.befrank.casedeveloperjava.domain.DeelnemerID;
import com.befrank.casedeveloperjava.domain.DeelnemersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WaardeberekeningService {

    private final DeelnemersRepository deelnemersRepository;

    public Double berekenVerwachteWaarde(final DeelnemerID deelnemerID, final LocalDate ingangsdatum) {
        final var deelnemer = deelnemersRepository.findById(deelnemerID);

        return 21341245.68;
    }
}
