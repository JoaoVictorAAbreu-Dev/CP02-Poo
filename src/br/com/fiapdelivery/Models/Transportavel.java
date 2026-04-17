package br.com.fiapdelivery.Models;

public interface Transportavel {

    String getPlaca();

    double getCapacidadeKg();

    default boolean suportaCarga(double pesoKg) {
        return pesoKg > 0 && pesoKg <= getCapacidadeKg();
    }
}