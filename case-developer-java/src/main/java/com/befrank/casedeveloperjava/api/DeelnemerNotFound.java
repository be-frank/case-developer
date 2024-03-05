package com.befrank.casedeveloperjava.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DeelnemerNotFound extends RuntimeException {

    public DeelnemerNotFound(final UUID deelnemerID) {
        super("Deelnemer met id '%s' niet gevonden.".formatted(deelnemerID));
    }
}
