package Eventos.Loja;

import Jogador.Personagem;

/**
 * Representa o item Adaga na loja, um equipamento de efeito passivo que 
 * concede um aumento permanente ao dano do jogador enquanto estiver equipado.
 */
public class Adaga implements Item{
    @Override
    public void efeito(Personagem jogador) {
        jogador.aumentarDano(2);
    }

    @Override
    public void perderEfeito(Personagem jogador) {
        jogador.reduzirDano(2);
    }

    @Override
    public boolean isPassivo() {
        return true;
    }

    @Override
    public String toString() {
        return "Adaga";
    }
}
