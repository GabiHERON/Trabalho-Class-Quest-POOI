package Jogador.Magia;

import Inimigos.Inimigo;
import Jogador.Magia.Condicao.Fraco;
import Jogador.Personagem;

import java.util.ArrayList;

/**
 * Representa a magia de Fraqueza, uma habilidade magica de debuff que afeta 
 * os alvos aplicando a condicao de enfraquecimento (Fraco) para reduzir seus danos.
 */
public class Fraqueza extends Magia{
    /**
     * Construtor padrao que inicializa a magia Fraqueza com seu respectivo 
     * tipo e custo de mana fixado em 2.
     */
    public Fraqueza(){
        super(EnumMagia.FRAQUEZA, 2);
    }

    @Override
    public void efeito(Personagem conjurador, ArrayList<Inimigo> alvos) {
        for(Inimigo alvo: alvos){
            alvo.adicionarCondicao(new Fraco());
        }
    }
}
