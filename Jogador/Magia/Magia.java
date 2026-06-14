package Jogador.Magia;

import Jogador.Personagem;
import Inimigos.Inimigo;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe abstrata que serve como base para a criacao de magias e habilidades 
 * magicas utilizaveis pelos personagens no jogo.
 */
public abstract class Magia {
    Random rand = new Random();
    private EnumMagia tipo;
    private int custo;

    /**
     * Construtor para definir os aspectos essenciais de uma nova magia.
     *
     * @param tipo o elemento identificador do enum da magia.
     * @param custo a quantidade de mana necessaria para a conjuracao.
     */
    public Magia(EnumMagia tipo, int custo){
        this.tipo = tipo;
        this.custo = custo;
    }

    /**
     * Define o comportamento e os resultados causados pela magia nos alvos 
     * quando for conjurada com sucesso.
     *
     * @param conjurador o personagem que esta executando a magia.
     * @param alvos a lista de inimigos afetados pela habilidade.
     */
    public abstract void efeito(Personagem conjurador, ArrayList<Inimigo> alvos);

    public int getCusto(){
        return custo;
    }

    public EnumMagia getTipo() {
        return tipo;
    }

    /**
     * Executa um teste logico de conjuracao rolando dados com base no poder 
     * do conjurador para verificar se a magia obteve sucesso.
     *
     * @param conjurador o personagem que tenta realizar o lancamento da magia.
     * @return true se o somatorio dos dados alcancar o limite minimo de 15, false caso contrario.
     */
    public boolean testaCondicao(Personagem conjurador){
        int total = 0;
        for(int i = 0; i < conjurador.getAtributos().getPoder(); i++) {
            int resultado = rand.nextInt(6) + 1;
            System.out.print("Dado" + i + ": " + resultado + " ");
            total += resultado;

        }
        if(total >= 15){
            System.out.println("Acerto Magico!");
            return true;
        }
        else{
            System.out.println();
            return false;
        }
    }

    @Override
    public String toString(){
        return tipo.getNome() + "(" + custo + ")";
    }
}