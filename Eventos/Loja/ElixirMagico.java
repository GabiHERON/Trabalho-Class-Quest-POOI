package Eventos.Loja;

import Jogador.Personagem;

/**
 * Representa o item Elixir Magico na loja, um consumivel ativo que
 * concede um aumento temporario a Forca de Magia do jogador quando utilizado.
 */

public class ElixirMagico implements Item{
    @Override
    public void efeito(Personagem jogador) {
        jogador.ganharForcaMagia(2);
    }

    @Override
    public void perderEfeito(Personagem jogador) {
        jogador.reduzirForcaMagia(2);
    }

    @Override
    public boolean isPassivo() {
        return false;
    }

    @Override
    public String toString() {
        return "Elixir Magico";
    }
}
