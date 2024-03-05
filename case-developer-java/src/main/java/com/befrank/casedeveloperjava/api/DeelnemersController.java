package com.befrank.casedeveloperjava.api;

import com.befrank.casedeveloperjava.domain.Deelnemer;
import com.befrank.casedeveloperjava.domain.DeelnemersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/deelnemers")
@CrossOrigin(originPatterns = "http://localhost:[*]")
public class DeelnemersController {

    private final DeelnemersRepository deelnemersRepository;

    @GetMapping
    public ResponseEntity<Set<Deelnemer>> getDeelnemers() {
        final var deelnemers = deelnemersRepository.findAll();
        return ResponseEntity.ok(deelnemers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deelnemer> getDeelnemer(@PathVariable("id") final UUID deelnemerID) {
        final Deelnemer deelnemer = deelnemersRepository.get(deelnemerID)
                .orElseThrow(() -> new DeelnemerNotFound(deelnemerID));
        return ResponseEntity.ok(deelnemer);
    }
}
