package br.com.fiapdelivery.Models;

public class Moto extends Veiculos {

    /** Indica se a moto possui baú acoplado. */
    private final boolean possuiBau;

    public Moto(String placa, double capacidadeKg, boolean possuiBau) {
        super(placa, capacidadeKg);
        this.possuiBau = possuiBau;
    }

    public boolean isPossuiBau() {
        return possuiBau;
    }

    @Override
    public String toString() {
        return String.format("Moto[placa=%s, capacidade=%.1f kg, baú=%s]",
                getPlaca(), getCapacidadeKg(), possuiBau ? "sim" : "não");
    }
}