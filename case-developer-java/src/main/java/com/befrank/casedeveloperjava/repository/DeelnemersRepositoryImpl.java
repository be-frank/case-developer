package com.befrank.casedeveloperjava.repository;

import com.befrank.casedeveloperjava.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
class DeelnemersRepositoryImpl implements DeelnemersRepository {

    private final DeelnemersJpaRepository jpaRepository;

    @Override
    public void add(final Deelnemer deelnemer) {
        final var dbDeelnemer = toDbObject(deelnemer);
        jpaRepository.save(dbDeelnemer);
    }

    private static com.befrank.casedeveloperjava.repository.model.Deelnemer toDbObject(Deelnemer deelnemer) {
        final var dbDeelnemer = new com.befrank.casedeveloperjava.repository.model.Deelnemer();
        dbDeelnemer.setId(deelnemer.getDeelnemerID().id());
        dbDeelnemer.setNaam(deelnemer.getNaam());
        dbDeelnemer.setGeboortedatum(Date.valueOf(deelnemer.getGeboortedatum()));
        dbDeelnemer.setEmail(deelnemer.getEmail().emailadres());
        final var adres = new com.befrank.casedeveloperjava.repository.model.Adres();
        adres.setStraatnaam(deelnemer.getAdres().straatnaam());
        adres.setHuisnummer(deelnemer.getAdres().huisnummer());
        adres.setPostcode(deelnemer.getAdres().postcode());
        adres.setWoonplaats(deelnemer.getAdres().woonplaats());
        dbDeelnemer.setAdres(adres);
        return dbDeelnemer;
    }

    @Override
    public Set<Deelnemer> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(com.befrank.casedeveloperjava.repository.model.Deelnemer::toDomainObject)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Deelnemer> findById(final DeelnemerID deelnemerID) {
        return jpaRepository.findById(deelnemerID.id())
                .map(com.befrank.casedeveloperjava.repository.model.Deelnemer::toDomainObject);
    }

}
