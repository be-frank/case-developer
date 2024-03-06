package com.befrank.casedeveloperjava.api;

import com.befrank.casedeveloperjava.api.resource.Deelnemer;
import com.befrank.casedeveloperjava.domain.DeelnemersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/deelnemers")
@CrossOrigin(originPatterns = "http://localhost:[*]")
public class DeelnemersController {

    private final DeelnemersRepository deelnemersRepository;

    @GetMapping
    public ResponseEntity<Set<Deelnemer>> getDeelnemers() {
        final var deelnemers = deelnemersRepository.findAll()
                .stream()
                .map(Deelnemer::fromDomainObject)
                .collect(Collectors.toSet());
        return ResponseEntity.ok(deelnemers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deelnemer> getDeelnemer(@PathVariable("id") final UUID deelnemerID) {
        final var deelnemer = deelnemersRepository.get(deelnemerID)
                .map(Deelnemer::fromDomainObject)
                .orElseThrow(() -> new DeelnemerNotFound(deelnemerID));
        return ResponseEntity.ok(deelnemer);
    }
}
