package com.befrank.casedeveloperjava.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "DEELNEMERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Deelnemer {

    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAAM")
    private String naam;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "GEBOORTEDATUM")
    private Date geboortedatum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADRES_ID", referencedColumnName = "ID")
    private Adres adres;
}
