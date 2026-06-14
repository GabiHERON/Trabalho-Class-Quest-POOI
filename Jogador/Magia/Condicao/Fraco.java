package Jogador.Magia.Condicao;

import Inimigos.Inimigo;

/**
 * Representa a condicao especifica Fraco, um efeito de status negativo 
 * que atua diminuindo o potencial ofensivo do inimigo afetado.
 */
public class Fraco extends Condicao{
    /**
     * Construtor padrao que inicializa a condicao com o nome "Fraco" 
     * e define sua duracao inicial para 4 rodadas.
     */
    public Fraco(){
        super("Fraco",4);
    }

    public void efeitoCondicao(Inimigo alvo){
        // Reduz o dano do Inimigo
    }

    @Override
    public String toString(){
        return "[" + getNome()+"]";
    }
}