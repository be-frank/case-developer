package com.befrank.casedeveloperjava.api.resource;

import java.util.UUID;

public record Waardeberekening(UUID deelnemerID, Integer pensioenleeftijd, double waarde) {
}
