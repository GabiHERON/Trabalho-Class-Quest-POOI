package Eventos.Loja;

import Jogador.Personagem;

/**
 * Representa o item Elixir da Força na loja, um consumivel ativo que 
 * concede um aumento temporario ao dano do jogador quando utilizado.
 */
public class ElixirDaForca implements Item{
    @Override
    public void efeito(Personagem jogador) {
        jogador.aumentarDano(3);
    }

    @Override
    public void perderEfeito(Personagem jogador) {
        jogador.reduzirDano(3);
    }

    @Override
    public boolean isPassivo() {
        return false;
    }

    @Override
    public String toString() {
        return "Elixir da Força";
    }
}
