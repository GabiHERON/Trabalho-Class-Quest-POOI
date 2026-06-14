package Jogador.Magia;

import Inimigos.Inimigo;
import Jogador.*;

import java.util.ArrayList;

/**
 * Representa a magia de Cura, uma habilidade magica de suporte focada em 
 * restaurar os pontos de vida do proprio conjurador.
 */
public class Curar extends Magia{
    /**
     * Construtor padrao que inicializa a magia Curar com seu respectivo 
     * tipo e custo de mana fixado em 2.
     */
    public Curar(){
        super(EnumMagia.CURAR,2);
    }

    @Override
    public void efeito(Personagem conjurador, ArrayList<Inimigo> alvos) {
        conjurador.recuperarVida(15 + + conjurador.getForcaMagia()*2);
    }
}
