package com.befrank.casedeveloperjava.db;

import com.befrank.casedeveloperjava.db.model.Deelnemer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface DeelnemersJpaRepository extends JpaRepository<Deelnemer, UUID> {
}
