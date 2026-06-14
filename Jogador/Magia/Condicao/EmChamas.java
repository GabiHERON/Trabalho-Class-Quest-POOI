package Jogador.Magia.Condicao;
import Inimigos.Inimigo;

/**
 * Representa a condicao especifica Em Chamas, um efeito de status negativo 
 * que causa dano continuo ao inimigo afetado a cada rodada.
 */
public class EmChamas extends Condicao{
    /**
     * Construtor padrao que inicializa a condicao com o nome "Em Chamas" 
     * e define sua duracao inicial para 3 rodadas.
     */
    public EmChamas(){
        super("Em Chamas",3);
    }

    @Override
    public void efeitoCondicao(Inimigo alvo){
        alvo.tomarDano(3);
    }

    @Override
    public String toString(){
        return "[" + getNome()+"]";
    }
}