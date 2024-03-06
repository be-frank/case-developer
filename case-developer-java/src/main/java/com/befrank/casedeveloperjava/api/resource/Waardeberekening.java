package com.befrank.casedeveloperjava.api.resource;

import java.time.LocalDate;
import java.util.UUID;

public record Waardeberekening(UUID deelnemerID, LocalDate ingangsdatum, Double waarde) {
}
