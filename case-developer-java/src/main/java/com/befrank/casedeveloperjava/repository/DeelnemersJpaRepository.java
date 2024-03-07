package com.befrank.casedeveloperjava.repository;

import com.befrank.casedeveloperjava.repository.model.Deelnemer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeelnemersJpaRepository extends JpaRepository<Deelnemer, UUID> {
}
