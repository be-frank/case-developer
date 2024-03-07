package com.befrank.casedeveloperjava.repository.model;

import com.befrank.casedeveloperjava.domain.DeelnemerID;
import com.befrank.casedeveloperjava.domain.Email;
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

    public com.befrank.casedeveloperjava.domain.Deelnemer toDomainObject() {
        return com.befrank.casedeveloperjava.domain.Deelnemer.builder()
                .deelnemerID(new DeelnemerID(id))
                .naam(naam)
                .geboortedatum(geboortedatum.toLocalDate())
                .adres(com.befrank.casedeveloperjava.domain.Adres.builder()
                        .straatnaam(adres.getStraatnaam())
                        .huisnummer(adres.getHuisnummer())
                        .postcode(adres.getPostcode())
                        .woonplaats(adres.getWoonplaats())
                        .build())
                .email(new Email(email))
                .build();
    }
}
