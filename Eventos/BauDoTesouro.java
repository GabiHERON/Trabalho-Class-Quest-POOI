package Eventos;

import Jogador.Personagem;

import java.util.Random;

/**
 * Representa o evento de interacao com um bau do tesouro, 
 * recompensando o jogador com uma quantia aleatoria de moedas.
 */public class BauDoTesouro implements Evento {
    @Override
    public void executar(Personagem jogador) {
        Random random = new Random();
        int moedas = random.nextInt(7,16);
        System.out.println("Você encontrou um baú com "+moedas+" moedas!");
        jogador.ganharMoedas(moedas);
    }
}
