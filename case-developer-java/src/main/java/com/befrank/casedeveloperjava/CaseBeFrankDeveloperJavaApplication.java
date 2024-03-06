package com.befrank.casedeveloperjava;

import com.befrank.casedeveloperjava.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class CaseBeFrankDeveloperJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseBeFrankDeveloperJavaApplication.class, args);
    }

    private Deelnemer John = Deelnemer.builder()
            .deelnemerID(new DeelnemerID(UUID.randomUUID()))
            .naam("John")
            .geboortedatum(LocalDate.now().minusYears(60))
            .email(new Email("john@example.com"))
            .adres(Adres.builder()
                    .straatnaam("Theo Snoekstraat")
                    .huisnummer("3")
                    .postcode("1391 EZ")
                    .woonplaats("Abcoude")
                    .build())
            .build();

    private Deelnemer Jane = Deelnemer.builder()
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

    @Bean
    CommandLineRunner init(final DeelnemersRepository deelnemersRepository) {
        return args -> Stream.of(John, Jane).forEach(deelnemersRepository::add);
    }
}
