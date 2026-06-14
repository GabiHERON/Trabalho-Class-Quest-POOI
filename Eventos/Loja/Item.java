package Eventos.Loja;

import Jogador.Personagem;

/**
 * Interface que define as operacoes e comportamentos obrigatorios para qualquer 
 * item do jogo, gerenciando a aplicacao, remocao e tipo de efeito no personagem.
 */
public interface Item {
    public void efeito(Personagem jogador);
    public void perderEfeito(Personagem jogador);
    public boolean isPassivo();
}