package br.com.fiapdelivery.Models;

public class Rota {

    /** Pacote a ser transportado nesta rota. */
    private final Pacote pacote;

    /** Veículo responsável pelo transporte. */
    private final Transportavel veiculo;

    public Rota(Pacote pacote, Transportavel veiculo) {
        if (pacote == null) {
            throw new IllegalArgumentException("O pacote da rota não pode ser nulo.");
        }
        if (veiculo == null) {
            throw new IllegalArgumentException("O veículo da rota não pode ser nulo.");
        }
        this.pacote = pacote;
        this.veiculo = veiculo;
    }

    public void iniciarTransporte() {
        if (!veiculo.suportaCarga(pacote.getPesoKg())) {
            System.out.printf(
                    "[ERRO] Veículo %s não suporta o pacote %s (%.1f kg excede %.1f kg de capacidade).%n",
                    veiculo.getPlaca(),
                    pacote.getCodigoRastreamento(),
                    pacote.getPesoKg(),
                    veiculo.getCapacidadeKg()
            );
            return;
        }
        pacote.atualizarStatus(StatusPacote.EM_TRANSITO);
        System.out.printf(
                "[ROTA] Transportando pacote %s no veículo %s | Status: %s%n",
                pacote.getCodigoRastreamento(),
                veiculo.getPlaca(),
                pacote.getStatus()
        );
    }

    public void finalizarEntrega() {
        pacote.atualizarStatus(StatusPacote.ENTREGUE);
        System.out.printf(
                "[ROTA] Pacote %s entregue com sucesso pelo veículo %s | Status: %s%n",
                pacote.getCodigoRastreamento(),
                veiculo.getPlaca(),
                pacote.getStatus()
        );
    }

    public Pacote getPacote() {
        return pacote;
    }

    public Transportavel getVeiculo() {
        return veiculo;
    }
}