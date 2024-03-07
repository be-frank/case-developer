package com.befrank.casedeveloperjava.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DIENSTVERBANDEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dienstverband {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DEELNEMER_ID", referencedColumnName = "ID")
    private Deelnemer deelnemer;

    @Column(name = "SALARIS")
    private Double salaris;

    @Column(name = "PARTTIME_PERCENTAGE")
    private Double parttimePercentage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WERKGEVER_ID", referencedColumnName = "ID")
    private Werkgever werkgever;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PENSIOENREGELING_ID", referencedColumnName = "ID")
    private Pensioenregeling pensioenregeling;

    @Column(name = "PENSIOENREKENING")
    private String pensioenrekening;
}
