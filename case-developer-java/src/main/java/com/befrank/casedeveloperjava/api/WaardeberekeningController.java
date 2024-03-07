package com.befrank.casedeveloperjava.api;

import com.befrank.casedeveloperjava.api.resource.Waardeberekening;
import com.befrank.casedeveloperjava.application.WaardeberekeningService;
import com.befrank.casedeveloperjava.domain.Deelnemer;
import com.befrank.casedeveloperjava.domain.DeelnemerID;
import com.befrank.casedeveloperjava.domain.DeelnemersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/waardeberekening")
@CrossOrigin(originPatterns = "http://localhost:[*]")
@Slf4j
public class WaardeberekeningController {

    private final DeelnemersRepository deelnemersRepository;
    private final WaardeberekeningService waardeberekeningService;

    @GetMapping
    public ResponseEntity<Waardeberekening> berekenPensioenwaarde(
            @RequestParam(name = "deelnemerID", required = true) final UUID deelnemerID,
            @RequestParam(name = "pensioenleeftijd", required = true) final Integer gewenstePensioenleeftijd) {
        final var deelnemer = deelnemersRepository
                .findById(new DeelnemerID(deelnemerID))
                .orElseThrow(() -> new DeelnemerNotFound(deelnemerID));
        if (deelnemer.getLeeftijd() > gewenstePensioenleeftijd) {
            throw new IllegalArgumentException("Gewenste pensioenleeftijd reeds bereikt.");
        }

        final double waarde = waardeberekeningService.berekenVerwachteWaarde(deelnemer, gewenstePensioenleeftijd);
        final var berekening = new Waardeberekening(deelnemerID, gewenstePensioenleeftijd, waarde);
        return ResponseEntity.ok(berekening);
    }
}
