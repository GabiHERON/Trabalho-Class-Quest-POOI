package Eventos.Loja;

import Jogador.Personagem;

/**
 * Representa o item Escudo na loja, um equipamento de efeito passivo que 
 * concede um aumento permanente a armadura do jogador enquanto estiver equipado.
 */
public class Escudo implements Item{
    @Override
    public void efeito(Personagem jogador) {
        jogador.ganharArmadura(2);
    }

    @Override
    public void perderEfeito(Personagem jogador) {
        jogador.reduzirArmadura(2);
    }

    @Override
    public boolean isPassivo() {
        return true;
    }

    @Override
    public String toString() {
        return "Escudo";
    }
}
