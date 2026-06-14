package Eventos;

import Inimigos.Inimigo;
import Inimigos.*;
import Jogador.Personagem;

import java.util.ArrayList;

/**
 * Representa o evento do Cemiterio do Mal, um combate especial onde modificadores 
 * ambientais baseados em rodadas ressuscitam esqueletos e curam necromantes.
 */
public class CemiterioDoMal extends Combate implements Evento{
    @Override
    /**
     * O evento do cemiterio gera esqueletos a cada 3 rodadas e cura o necromante a cada 2
     */
    public void eventoRodada(int rodada, ArrayList<Inimigo> inimigos){
        if(rodada % 3 == 0){
            System.out.println("Os Mortos Levantam!!!");
            inimigos.add(new Esqueleto());
        }
        if(rodada % 2 == 0){
            System.out.println("A vida eh valorizada demais...");
            for(Inimigo inimigo:inimigos){
                if(inimigo instanceof Necromante){
                    inimigo.recuperarVida(5);
                    break;
                }
            }
        }
    }

    @Override
    public void executar(Personagem jogador) {

        ArrayList<Inimigo> inimigos= new ArrayList<>();
        inimigos.add(new Necromante());
        inimigos.add(new Esqueleto());

        combate(jogador,inimigos,25);
    }
}
