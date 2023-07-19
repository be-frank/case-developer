package com.befrank.casedeveloperjava;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface DeelnemerRepository extends CrudRepository<Deelnemer, Long> {
    List<Deelnemer> findAll();

    @Override
    Optional<Deelnemer> findById(Long aLong);
}
