package com.befrank.casedeveloperjava.api.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deelnemer {

    private UUID id;
    private String naam;
    private String email;

    public static Deelnemer fromDomainObject(final com.befrank.casedeveloperjava.domain.Deelnemer entity) {
        return Deelnemer.builder()
                .id(entity.getDeelnemerID().id())
                .naam(entity.getNaam())
                .email(entity.getEmail().emailadres())
                .build();
    }
}
