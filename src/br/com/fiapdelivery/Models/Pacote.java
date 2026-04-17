package br.com.fiapdelivery.Models;

/**
 * Representa um pacote a ser transportado pelo sistema FiapDelivery.
 *
 * <p>Encapsula o código de rastreamento, o peso e o status de entrega.
 * O status é controlado pelo enum {@link StatusPacote}, garantindo que
 * apenas transições válidas sejam realizadas.</p>
 *
 * @author FiapDelivery
 * @version 1.0
 */
public class Pacote {

    /** Código único de rastreamento (ex: {@code "BR999"}). */
    private final String codigoRastreamento;

    /** Peso do pacote em quilogramas. */
    private final double pesoKg;

    /** Status atual do pacote no fluxo de entrega. */
    private StatusPacote status;

    /**
     * Constrói um pacote com status inicial {@link StatusPacote#PENDENTE}.
     *
     * @param codigoRastreamento código único de rastreamento (não pode ser vazio)
     * @param pesoKg             peso em kg (deve ser maior que zero)
     * @throws IllegalArgumentException se o código for inválido ou o peso não for positivo
     */
    public Pacote(String codigoRastreamento, double pesoKg) {
        if (codigoRastreamento == null || codigoRastreamento.isBlank()) {
            throw new IllegalArgumentException("O código de rastreamento não pode ser vazio.");
        }
        if (pesoKg <= 0) {
            throw new IllegalArgumentException(
                    "Peso inválido: " + pesoKg + " kg. Deve ser maior que zero."
            );
        }
        this.codigoRastreamento = codigoRastreamento.toUpperCase().trim();
        this.pesoKg = pesoKg;
        this.status = StatusPacote.PENDENTE;
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    /**
     * Retorna o código de rastreamento do pacote.
     *
     * @return código de rastreamento
     */
    public String getCodigoRastreamento() {
        return codigoRastreamento;
    }

    /**
     * Retorna o peso do pacote em quilogramas.
     *
     * @return peso em kg
     */
    public double getPesoKg() {
        return pesoKg;
    }

    /**
     * Retorna o status atual do pacote.
     *
     * @return status atual
     */
    public StatusPacote getStatus() {
        return status;
    }

    // -------------------------------------------------------------------------
    // Comportamentos
    // -------------------------------------------------------------------------

    /**
     * Atualiza o status do pacote.
     *
     * @param novoStatus novo status (não pode ser nulo)
     * @throws IllegalArgumentException se {@code novoStatus} for nulo
     */
    public void atualizarStatus(StatusPacote novoStatus) {
        if (novoStatus == null) {
            throw new IllegalArgumentException("O novo status não pode ser nulo.");
        }
        this.status = novoStatus;
    }

    @Override
    public String toString() {
        return String.format("Pacote[cod=%s, peso=%.1f kg, status=%s]",
                codigoRastreamento, pesoKg, status);
    }
}