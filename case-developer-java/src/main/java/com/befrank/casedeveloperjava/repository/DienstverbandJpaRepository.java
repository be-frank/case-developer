package com.befrank.casedeveloperjava.repository;

import com.befrank.casedeveloperjava.repository.model.Dienstverband;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DienstverbandJpaRepository extends JpaRepository<Dienstverband, Long> {

    Optional<Dienstverband> findByDeelnemerId(UUID deelnemerID);
}
