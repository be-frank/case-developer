package com.befrank.casedeveloperjava.api.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deelnemer {

    private UUID id;
    private String naam;
    private String email;
    private LocalDate geboortedatum;

    public static Deelnemer fromDomainObject(final com.befrank.casedeveloperjava.domain.deelnemer.Deelnemer entity) {
        return Deelnemer.builder()
                .id(entity.getDeelnemerID().id())
                .naam(entity.getNaam())
                .email(entity.getEmail().emailadres())
                .geboortedatum(entity.getGeboortedatum())
                .build();
    }
}
