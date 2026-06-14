package Eventos.Loja;

import Jogador.Personagem;

/**
 * Representa o item Elixir Revitalizador na loja, um consumivel ativo que
 * restaura completamente os pontos de vida do jogador quando utilizado.
 */
public class ElixirRevitalizador implements Item{
    @Override
    public void efeito(Personagem jogador) {
        jogador.restaurarVida();
    }

    @Override
    public void perderEfeito(Personagem jogador) {
    }

    @Override
    public boolean isPassivo() {
        return false;
    }

    @Override
    public String toString() {
        return "Elixir Revitalizador";
    }
}
