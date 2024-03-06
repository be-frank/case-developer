package com.befrank.casedeveloperjava;

import com.befrank.casedeveloperjava.db.DeelnemersJpaRepository;
import com.befrank.casedeveloperjava.db.DienstverbandJpaRepository;
import com.befrank.casedeveloperjava.db.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class CaseBeFrankDeveloperJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseBeFrankDeveloperJavaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(final DeelnemersJpaRepository deelnemersJpaRepository, final DienstverbandJpaRepository dienstverbandJpaRepository) {
        Deelnemer john = Deelnemer.builder()
                .id(UUID.randomUUID())
                .naam("John")
                .email("john@example.com")
                .geboortedatum(Date.valueOf(LocalDate.now().minusYears(60)))
                .adres(Adres.builder()
                        .id(1L)
                        .straatnaam("Theo Snoekstraat")
                        .huisnummer("3")
                        .postcode("1391 EZ")
                        .woonplaats("Abcoude")
                        .build())
                .build();
        Deelnemer jane = Deelnemer.builder()
                .id(UUID.randomUUID())
                .naam("Jane")
                .email("jane@example.com")
                .geboortedatum(Date.valueOf(LocalDate.of(1989, 4, 23)))
                .adres(Adres.builder()
                        .id(2L)
                        .straatnaam("De Cleijne Cleij")
                        .huisnummer("22")
                        .postcode("1391 DR")
                        .woonplaats("Abcoude")
                        .build())
                .build();
        Werkgever werkgever = new Werkgever(1L, "BeFrank");
        Pensioenregeling regeling = Pensioenregeling.builder()
                .id(1L)
                .werkgever(werkgever)
                .franchise(15599.0)
                .beschikbarePremiePercentage(5.0)
                .build();
        Dienstverband dienstverbandJohn = Dienstverband.builder()
                .id(5L)
                .deelnemer(john)
                .salaris(60000.0)
                .parttimePercentage(80.0)
                .werkgever(werkgever)
                .pensioenregeling(regeling)
                .pensioenrekening("REKENINGNR_0123")
                .build();
        Dienstverband dienstverbandJane = Dienstverband.builder()
                .id(9L)
                .deelnemer(jane)
                .salaris(70000.0)
                .parttimePercentage(100.0)
                .werkgever(werkgever)
                .pensioenregeling(regeling)
                .pensioenrekening("REKENINGNR_9876")
                .build();
        return args -> {
            deelnemersJpaRepository.save(john);
            deelnemersJpaRepository.save(jane);
            dienstverbandJpaRepository.save(dienstverbandJohn);
            dienstverbandJpaRepository.save(dienstverbandJane);
        };
    }
}
