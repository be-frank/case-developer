package com.befrank.casedeveloperjava.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADRESSEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STRAAT")
    private String straatnaam;
    @Column(name = "HUISNUMMER")
    private String huisnummer;
    @Column(name = "POSTCODE")
    private String postcode;
    @Column(name = "WOONPLAATS")
    private String woonplaats;
}
