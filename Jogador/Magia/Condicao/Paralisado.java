package Jogador.Magia.Condicao;

import Inimigos.Inimigo;

/**
 * Representa a condicao especifica Paralisado, um efeito de status negativo 
 * que impede temporariamente as acoes ofensivas do inimigo afetado.
 */
public class Paralisado extends Condicao{
    /**
     * Construtor padrao que inicializa a condicao com o nome "Paralisado" 
     * e define sua duracao inicial para 2 rodadas.
     */
    public Paralisado(){
        super("Paralisado",2);
    }

    @Override
    public void efeitoCondicao(Inimigo alvo){
        // Inimigo nao pode atacar
    }
    @Override
    public String toString(){
        return "[" + getNome()+"]";
    }

}