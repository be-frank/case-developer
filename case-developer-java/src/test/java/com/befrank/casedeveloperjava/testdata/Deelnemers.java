package com.befrank.casedeveloperjava.testdata;

import com.befrank.casedeveloperjava.domain.Adres;
import com.befrank.casedeveloperjava.domain.Deelnemer;
import com.befrank.casedeveloperjava.domain.DeelnemerID;
import com.befrank.casedeveloperjava.domain.Email;

import java.time.LocalDate;
import java.util.UUID;

public class Deelnemers {

    public static Deelnemer John = Deelnemer.builder()
                .deelnemerID(new DeelnemerID(UUID.randomUUID()))
                .naam("John")
                .geboortedatum(LocalDate.now().minusYears(60))
                .email(new Email("wim@example.com"))
                .adres(Adres.builder()
                        .straatnaam("Theo Snoekstraat")
                        .huisnummer("3")
                        .postcode("1391 EZ")
                        .woonplaats("Abcoude")
                        .build())
                .build();

    public static Deelnemer Jane = Deelnemer.builder()
                .deelnemerID(new DeelnemerID(UUID.randomUUID()))
                .naam("Jane")
                .geboortedatum(LocalDate.of(1989, 4, 23))
                .email(new Email("jane@example.com"))
                .adres(Adres.builder()
                        .straatnaam("De Cleijne Cleij")
                        .huisnummer("22")
                        .postcode("1391 DR")
                        .woonplaats("Abcoude")
                        .build())
                .build();
}
