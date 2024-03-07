package com.befrank.casedeveloperjava.api;

import com.befrank.casedeveloperjava.api.resource.Waardeberekening;
import com.befrank.casedeveloperjava.application.WaardeberekeningService;
import com.befrank.casedeveloperjava.domain.DeelnemerID;
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

    private final WaardeberekeningService waardeberekeningService;

    @GetMapping
    public ResponseEntity<Waardeberekening> berekenPensioenwaarde(
            @RequestParam(name = "deelnemerID", required = true) final UUID deelnemerID,
            @RequestParam(name = "pensioenleeftijd", required = true) final Integer pensioenleeftijd) {

        final var waarde = Double.valueOf(350_000.00);
//        final Double waarde = waardeberekeningService.berekenVerwachteWaarde(new DeelnemerID(deelnemerID), pensioenleeftijd);
        final var berekening = new Waardeberekening(deelnemerID, pensioenleeftijd, waarde);
        return ResponseEntity.ok(berekening);
    }
}
