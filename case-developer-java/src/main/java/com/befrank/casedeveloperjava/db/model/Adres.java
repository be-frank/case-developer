package com.befrank.casedeveloperjava.db.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ADRESSEN")
@Data
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
