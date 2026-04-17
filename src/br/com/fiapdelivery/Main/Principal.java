package br.com.fiapdelivery.Main;

import br.com.fiapdelivery.Models.Caminhao;
import br.com.fiapdelivery.Models.Moto;
import br.com.fiapdelivery.Models.Pacote;
import br.com.fiapdelivery.Models.Rota;


public class Principal {

    public static void main(String[] args) {

        System.out.println("=== FiapDelivery — Sistema de Logística ===\n");

        // --- Cenário 1: Entrega de pacote pesado via caminhão ---
        Caminhao caminhao = new Caminhao("ABC1D23", 500.0, 4);
        Pacote pacotePesado = new Pacote("BR999", 120.5);

        System.out.println("Veículo : " + caminhao);
        System.out.println("Pacote  : " + pacotePesado);

        Rota rotaCaminhao = new Rota(pacotePesado, caminhao);
        rotaCaminhao.iniciarTransporte();
        rotaCaminhao.finalizarEntrega();

        System.out.println();

        // --- Cenário 2: Entrega de pacote leve via moto com baú ---
        Moto moto = new Moto("XYZ5E67", 30.0, true);
        Pacote pacoteLeve = new Pacote("SP042", 8.0);

        System.out.println("Veículo : " + moto);
        System.out.println("Pacote  : " + pacoteLeve);

        Rota rotaMoto = new Rota(pacoteLeve, moto);
        rotaMoto.iniciarTransporte();
        rotaMoto.finalizarEntrega();

        System.out.println();

        // --- Cenário 3: Tentativa de entrega com carga excedente ---
        Moto motoSemBau = new Moto("DEF3G45", 15.0, false);
        Pacote pacotePesadoDemais = new Pacote("RJ011", 25.0);

        System.out.println("Veículo : " + motoSemBau);
        System.out.println("Pacote  : " + pacotePesadoDemais);

        Rota rotaInvalida = new Rota(pacotePesadoDemais, motoSemBau);
        rotaInvalida.iniciarTransporte();

        System.out.println();

        // --- Cenário 4: Validação de construtor ---
        System.out.println("--- Teste de validação ---");
        try {
            new Caminhao("", -500.0, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("[VALIDAÇÃO] " + e.getMessage());
        }
    }
}