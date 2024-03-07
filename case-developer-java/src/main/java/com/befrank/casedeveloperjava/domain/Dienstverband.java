package com.befrank.casedeveloperjava.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dienstverband {

    private Deelnemer deelnemer;
    private Double salaris;
    private Double parttimePercentage;

    private Pensioenregeling pensioenregeling;

    private Pensioenrekening pensioenrekening;

    public Double jaarlijksePremie() {
        double franchise = pensioenregeling.franchise();
        double beschikbarePRemiePercentage = pensioenregeling.beschikbarePremiePercentage();
        return (salaris - franchise) * (parttimePercentage / 100) * (beschikbarePRemiePercentage / 100);
    }
}