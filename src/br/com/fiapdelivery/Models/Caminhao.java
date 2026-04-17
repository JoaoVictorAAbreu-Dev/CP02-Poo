package br.com.fiapdelivery.Models;

public class Caminhao extends Veiculos {

    private final int numeroDeEixos;

    public Caminhao(String placa, double capacidadeKg, int numeroDeEixos) {
        super(placa, capacidadeKg);
        if (numeroDeEixos < 2) {
            throw new IllegalArgumentException(
                    "Número de eixos inválido: " + numeroDeEixos + ". Mínimo é 2."
            );
        }
        this.numeroDeEixos = numeroDeEixos;
    }

    public int getNumeroDeEixos() {
        return numeroDeEixos;
    }

    @Override
    public String toString() {
        return String.format("Caminhao[placa=%s, capacidade=%.1f kg, eixos=%d]",
                getPlaca(), getCapacidadeKg(), numeroDeEixos);
    }
}