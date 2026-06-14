package Inimigos;

import Jogador.Magia.Condicao.*;

/**
 * Representa o inimigo Lobo, uma fera veloz que causa uma quantidade de dano 
 * consideravel caso nao esteja sob o efeito de paralisia.
 */
public class Lobo extends Inimigo {
    /**
     * Construtor padrao que inicializa o Lobo com seu nome, 
     * vida maxima fixada em 20 e valor de ataque base igual a 5.
     */
    public Lobo(){
        super("Lobo",20,5);
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
