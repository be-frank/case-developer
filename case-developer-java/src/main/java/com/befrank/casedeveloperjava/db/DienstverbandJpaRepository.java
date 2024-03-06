package com.befrank.casedeveloperjava.db;

import com.befrank.casedeveloperjava.db.model.Dienstverband;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DienstverbandJpaRepository extends JpaRepository<Dienstverband, Long> {
}
