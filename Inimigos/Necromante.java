package Inimigos;

import Jogador.Magia.Condicao.Condicao;

/**
 * Representa o inimigo Necromante, um conjurador das trevas com grande quantidade 
 * de vida que realiza ataques contra o jogador caso nao esteja paralisado.
 */
public class Necromante extends Inimigo {
    /**
     * Construtor padrao que inicializa o Necromante com seu nome, 
     * vida maxima fixada em 50 e valor de ataque base igual a 5.
     */
    public Necromante(){
        super("Necromante",50,5);
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
