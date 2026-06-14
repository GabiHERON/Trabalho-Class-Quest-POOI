package Jogador.Magia;

import Inimigos.Inimigo;
import Jogador.*;
import Jogador.Magia.Condicao.EmChamas;
import Jogador.Magia.Condicao.Paralisado;

import java.util.ArrayList;

/**
 * Representa a magia Bola de Fogo, uma habilidade magica de ataque em area 
 * que causa dano a todos os inimigos e possui a chance de aplicar uma 
 * condicao de queimadura (EmChamas).
 */
public class BolaDeFogo extends Magia{
    private int dano;

    /**
     * Construtor padrao que inicializa a magia Bola de Fogo com seu respectivo 
     * tipo e custo de mana fixado em 4.
     */
    public BolaDeFogo(){
        super(EnumMagia.BOLA_DE_FOGO,4);
    }

    @Override
    public void efeito(Personagem conjurador, ArrayList<Inimigo> alvos){
        for(Inimigo alvo: alvos){
            alvo.tomarDano(6 + conjurador.getForcaMagia());
            if(testaCondicao(conjurador)){
                alvo.adicionarCondicao(new EmChamas());
            }
        }
    }
}
