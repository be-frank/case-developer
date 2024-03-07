package com.befrank.casedeveloperjava.domain.deelnemer;

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
    private double salaris;
    private double parttimePercentage;

    private Pensioenregeling pensioenregeling;

    private Pensioenrekening pensioenrekening;

    public double jaarlijksePremie() {
        double franchise = pensioenregeling.franchise();
        double beschikbarePRemiePercentage = pensioenregeling.beschikbarePremiePercentage();
        return (salaris - franchise) * (parttimePercentage / 100) * (beschikbarePRemiePercentage / 100);
    }
}
