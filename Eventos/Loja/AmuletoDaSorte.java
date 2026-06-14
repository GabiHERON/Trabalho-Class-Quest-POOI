package Eventos.Loja;

import Jogador.Personagem;

/**
 * Representa o item Amuleto da Sorte na loja, um equipamento passivo que 
 * melhora a precisao do jogador ao reduzir a margem numerica necessaria para acertar ataques.
 */
public class AmuletoDaSorte implements Item{
    @Override
    public void efeito(Personagem jogador) {
        jogador.reduzirMargemAcerto(1);
    }

    @Override
    public void perderEfeito(Personagem jogador) {
        jogador.aumentarMargemAcerto(1);
    }

    @Override
    public boolean isPassivo() {
        return true;
    }

    @Override
    public String toString() {
        return "Amuleto da Sorte";
    }
}
