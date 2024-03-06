package com.befrank.casedeveloperjava.api.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class DeelnemerDetails extends Deelnemer {

    private LocalDate geboortedatum;
    private Adres adres;

    public static DeelnemerDetails fromDomainObject(final com.befrank.casedeveloperjava.domain.Deelnemer entity) {
        final var details = new DeelnemerDetails();
        details.setId(entity.getDeelnemerID().id());
        details.setNaam(entity.getNaam());
        details.setEmail(entity.getEmail().emailadres());
        details.setGeboortedatum(entity.getGeboortedatum());
        final var adres = new Adres(entity.getAdres().straatnaam(), entity.getAdres().huisnummer(), entity.getAdres().postcode(), entity.getAdres().woonplaats());
        details.setAdres(adres);
        return details;
    }
}
