package com.befrank.casedeveloperjava.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PENSIOENREGELINGEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pensioenregeling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WERKGEVER_ID", referencedColumnName = "ID")
    private Werkgever werkgever;

    @Column(name = "FRANCHISE")
    private double franchise;

    @Column(name = "BESCHIKBARE_PREMIE_PERCENTAGE")
    private double beschikbarePremiePercentage;

}
