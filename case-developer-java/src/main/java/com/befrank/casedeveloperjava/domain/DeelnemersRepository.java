package com.befrank.casedeveloperjava.domain;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface DeelnemersRepository {

    void add(final Deelnemer deelnemer);

    void clear();

    Set<Deelnemer> findAll();

    Optional<Deelnemer> get(final UUID deelnemerID);
}