package com.befrank.casedeveloperjava.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Deelnemer {

    private DeelnemerID deelnemerID;

    private String naam;
    private Adres adres;
    private Email email;
    private LocalDate geboortedatum;

}
