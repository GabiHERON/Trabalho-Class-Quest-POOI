package Eventos;

import Inimigos.Goblin;
import Inimigos.Inimigo;
import Jogador.Personagem;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representa o evento tematico da Caverna dos Goblins, instanciando um 
 * combate obrigatorio contra um grupo de goblins e definindo sua recompensa.
 */
public class CavernaDosGoblins extends Combate implements Evento{

    public void eventoRodada(int rodada, ArrayList<Inimigo> inimigos){}

    @Override
    public void executar(Personagem jogador) {

        ArrayList<Inimigo> inimigos= new ArrayList<>();
        inimigos.add(new Goblin());
        inimigos.add(new Goblin());

        combate(jogador,inimigos,5);
    }

}
