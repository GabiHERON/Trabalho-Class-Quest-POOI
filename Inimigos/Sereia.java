package Inimigos;

import Jogador.Magia.Condicao.Condicao;

/**
 * Representa o inimigo Sereia, uma criatura mistica das aguas que realiza 
 * ataques contra o jogador caso nao esteja sob o efeito de paralisia.
 */
public class Sereia extends Inimigo {
    /**
     * Construtor padrao que inicializa o inimigo Sereia com seu nome, 
     * vida maxima fixada em 30 e valor de ataque base igual a 3.
     */
    public Sereia(){
        super("Sereia",30,3);
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
