package Eventos;

import Jogador.Personagem;

/**
 * Representa o evento da Fogueira, um ponto de descanso seguro no mapa 
 * que permite ao jogador recuperar totalmente seus pontos de vida.
 */
public class Fogueira implements Evento{
    public void executar(Personagem jogador){
        System.out.println("Você faz uma fogueira e descansa ao lado das chamas");
        jogador.restaurarVida();
        System.out.println("(Vida restaurada para o valor máximo)");
    }
}
