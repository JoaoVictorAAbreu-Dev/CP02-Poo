package br.com.fiapdelivery.Models;


public abstract class Veiculos implements Transportavel {

    private final String placa;

    private final double capacidadeKg;

    protected Veiculos(String placa, double capacidadeKg) {
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("A placa do veículo não pode ser vazia.");
        }
        if (capacidadeKg <= 0) {
            throw new IllegalArgumentException(
                    "Capacidade inválida: " + capacidadeKg + " kg. Deve ser maior que zero."
            );
        }
        this.placa = placa.toUpperCase().trim();
        this.capacidadeKg = capacidadeKg;
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public double getCapacidadeKg() {
        return capacidadeKg;
    }

    @Override
    public String toString() {
        return String.format("%s[placa=%s, capacidade=%.1f kg]",
                getClass().getSimpleName(), placa, capacidadeKg);
    }
}