package br.com.fiapdelivery.Models;

public enum StatusPacote {

    /** Pacote registrado, aguardando coleta. */
    PENDENTE("Pendente"),

    /** Pacote coletado e em trânsito. */
    EM_TRANSITO("Em trânsito"),

    /** Pacote entregue com sucesso ao destinatário. */
    ENTREGUE("Entregue"),

    /** Tentativa de entrega falhou; pacote retornou ao centro de distribuição. */
    DEVOLVIDO("Devolvido");

    // -------------------------------------------------------------------------

    private final String descricao;

    StatusPacote(String descricao) {
        this.descricao = descricao;
    }


    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}