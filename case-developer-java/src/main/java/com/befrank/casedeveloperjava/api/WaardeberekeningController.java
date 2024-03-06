package com.befrank.casedeveloperjava.api;

import com.befrank.casedeveloperjava.api.resource.Waardeberekening;
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

    @GetMapping
    public ResponseEntity<Waardeberekening> berekenPensioenwaarde(
            @RequestParam(name = "deelnemerID", required = true) final UUID deelnemerID,
            @RequestParam(name = "ingangsdatum", required = true) final LocalDate ingangsdatum) {
        // TODO
        final var waarde = Double.valueOf(350_000.00);
        final var berekening = new Waardeberekening(deelnemerID, ingangsdatum, waarde);
        return ResponseEntity.ok(berekening);
    }
}
