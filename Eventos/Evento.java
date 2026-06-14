package Eventos;
import Jogador.*;

/**
 * Interface que define o contrato para a execucao de qualquer evento 
 * ou encontro interativo dentro do fluxo do jogo.
 */
public interface Evento {
    public void executar(Personagem jogador);
}