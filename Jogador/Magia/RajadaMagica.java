package Jogador.Magia;

import Inimigos.Inimigo;
import Jogador.Personagem;

import java.util.ArrayList;

/**
 * Representa a magia Rajada Magica, uma habilidade ofensiva focada em disparar 
 * projeteis de energia pura para causar dano direto a todos os alvos selecionados.
 */
public class RajadaMagica extends Magia{
    /**
     * Construtor padrao que inicializa a magia Rajada Magica com seu respectivo 
     * tipo e custo de mana fixado em 3.
     */
    public RajadaMagica(){
        super(EnumMagia.RAJADA_MAGICA, 3);
    }

    @Override
    public void efeito(Personagem conjurador, ArrayList<Inimigo> alvos) {
        for(Inimigo alvo: alvos){
            alvo.tomarDano(8 + conjurador.getForcaMagia());
        }
    }
}
