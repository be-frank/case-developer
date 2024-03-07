package com.befrank.casedeveloperjava.domain;

import java.util.Optional;

public interface DienstverbandRepository {

    Optional<Dienstverband> findByDeelnemer(final Deelnemer deelnemer);
}
