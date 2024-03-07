package com.befrank.casedeveloperjava.repository;

import com.befrank.casedeveloperjava.domain.deelnemer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
class DienstverbandRepositoryImpl implements DienstverbandRepository {

    private final DienstverbandJpaRepository dienstverbandJpaRepository;

    @Override
    public Optional<Dienstverband> findByDeelnemer(Deelnemer deelnemer) {
        return this.dienstverbandJpaRepository.findByDeelnemerId(deelnemer.getDeelnemerID().id())
                .map(dienstverband -> Dienstverband.builder()
                        .deelnemer(dienstverband.getDeelnemer().toDomainObject())
                        .salaris(dienstverband.getSalaris())
                        .parttimePercentage(dienstverband.getParttimePercentage())
                        .pensioenregeling(new Pensioenregeling(dienstverband.getPensioenregeling().getFranchise(), dienstverband.getPensioenregeling().getBeschikbarePremiePercentage()))
                        .pensioenrekening(new Pensioenrekening(dienstverband.getPensioenrekening()))
                        .build());
    }
}
