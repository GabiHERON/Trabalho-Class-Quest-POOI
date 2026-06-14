package Inimigos;

import Jogador.Magia.Condicao.*;

/**
 * Representa o inimigo Goblin, uma criatura agil com atributos intermediarios 
 * que ataca o jogador a cada turno caso nao esteja incapacitada por paralisia.
 */
public class Goblin extends Inimigo {
    /**
     * Construtor padrao que inicializa o Goblin com seu nome, 
     * vida maxima fixada em 10 e valor de ataque base igual a 4.
     */
    public Goblin(){
        super("Goblin",15,4);
    }


    @Override
    public String toString(){
        String status = "";
        for(Condicao cond  : getCondicoes()){
            status +=  cond;
        }
        return  getNome() + " " + getVida() + "/" + getVidaMaxima() + status;
    }
}
