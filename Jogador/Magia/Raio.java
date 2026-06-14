package Jogador.Magia;

import Inimigos.Inimigo;
import Jogador.*;
import Jogador.Magia.Condicao.Paralisado;

import java.util.ArrayList;

/**
 * Representa a magia Raio, uma habilidade magica ofensiva que atinge os inimigos 
 * causandodano e possuindo uma chance de aplicar a condicao de paralisia (Paralisado).
 */
public class Raio extends Magia{
    /**
     * Construtor padrao que inicializa a magia Raio com seu respectivo 
     * tipo e custo de mana fixado em 4.
     */
    public Raio(){
        super(EnumMagia.RAIO,4);
    }

    @Override
    public void efeito(Personagem conjurador, ArrayList<Inimigo> alvos) {
        for(Inimigo alvo: alvos){
            alvo.tomarDano(6 + conjurador.getForcaMagia());
            if(testaCondicao(conjurador)){
                alvo.adicionarCondicao(new Paralisado());
            }
        }
    }
}
