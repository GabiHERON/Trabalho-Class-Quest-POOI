package Eventos;

import Inimigos.Inimigo;
import Inimigos.Sereia;
import Jogador.Personagem;

import java.util.ArrayList;

/**
 * Representa o evento do Lago Encantado, um combate místico contra sereias
 * onde o ambiente cura todos os inimigos presentes a cada três rodadas.
 */
public class LagoEncantado extends Combate implements Evento{
    @Override
    public void eventoRodada(int rodada, ArrayList<Inimigo> inimigos){
        if(rodada % 3 == 0){
            System.out.println("As sereias cantam...");
            for(Inimigo inimigo:inimigos){
                inimigo.recuperarVida(10);
            }
        }
    }

    @Override
    public void executar(Personagem jogador) {

        ArrayList<Inimigo> inimigos= new ArrayList<>();
        inimigos.add(new Sereia());
        inimigos.add(new Sereia());
        inimigos.add(new Sereia());

        combate(jogador,inimigos,15);
    }
}
