package Eventos;

import Inimigos.Lobo;
import Inimigos.Inimigo;
import Jogador.Personagem;

import java.util.ArrayList;

/**
 * Representa o evento da Floresta Escura, um combate dinâmico onde novos lobos
 * podem entrar na batalha como reforço a cada três rodadas.
 */
public class FlorestaEscura extends Combate implements Evento{
    @Override
    public void eventoRodada(int rodada, ArrayList<Inimigo> inimigos){
        if(rodada % 3 == 0){
            System.out.println("Um novo inimigo se aproxima...");
            inimigos.add(new Lobo());
        }
    }

    @Override
    public void executar(Personagem jogador) {

        ArrayList<Inimigo> inimigos= new ArrayList<>();
        inimigos.add(new Lobo());
        inimigos.add(new Lobo());

        combate(jogador,inimigos,10);
    }
}
