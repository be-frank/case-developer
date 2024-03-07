package com.befrank.casedeveloperjava.domain.deelnemer;

import java.util.Optional;
import java.util.Set;

public interface DeelnemersRepository {

    void add(final Deelnemer deelnemer);

    Set<Deelnemer> findAll();

    Optional<Deelnemer> findById(final DeelnemerID deelnemerID);
}
