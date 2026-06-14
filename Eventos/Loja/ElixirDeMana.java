package Eventos.Loja;

import Jogador.Personagem;

/**
 * Representa o item Elixir de Mana na loja, um consumivel ativo que
 * restaura a mana do jogador quando utilizado.
 */

public class ElixirDeMana implements Item{
    @Override
    public void efeito(Personagem jogador) {
        jogador.restaurarMana();
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
        return "Elixir de Mana";
    }
}
