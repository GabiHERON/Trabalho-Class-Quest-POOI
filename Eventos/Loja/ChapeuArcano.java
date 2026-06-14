package Eventos.Loja;

import Jogador.Personagem;

/**
 * Representa o item Chapeu Arcano na loja, um equipamento de efeito passivo que
 * concede um aumento permanente a Forca de Magia do jogador enquanto estiver equipado.
 */

public class ChapeuArcano implements Item{
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
        return true;
    }

    @Override
    public String toString() {
        return "Chapeu arcano";
    }
}
