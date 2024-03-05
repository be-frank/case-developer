package com.befrank.casedeveloperjava.domain;

import lombok.Builder;

@Builder
public record Adres(String straatnaam, String huisnummer, String postcode, String woonplaats) {
}
