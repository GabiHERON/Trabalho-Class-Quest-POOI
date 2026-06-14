package Inimigos;

import Jogador.Magia.Condicao.Condicao;

/**
 * Representa o inimigo Esqueleto, uma unidade morta-viva basica que realiza 
 * ataques fisicos simples caso nao esteja sob o efeito de paralisia.
 */
public class Esqueleto extends Inimigo {
    /**
     * Construtor padrao que inicializa o Esqueleto com seu nome, 
     * vida maxima fixada em 10 e valor de ataque base igual a 2.
     */
    public Esqueleto(){
        super("Esqueleto",10,3);
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
