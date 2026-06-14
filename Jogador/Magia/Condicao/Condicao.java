package Jogador.Magia.Condicao;

import Inimigos.Inimigo;

/**
 * Representa uma condicao de status abstrata que pode ser aplicada a inimigos,
 * possuindo um controle de duracao por turnos e efeitos especificos.
 */
public abstract class Condicao {
    private String nome;
    private int duracao;

    /**
     * Construtor para inicializar uma nova condicao com seu nome e tempo de duracao.
     *
     * @param nome o nome identificador da condicao.
     * @param duracao a quantidade de rodadas/turnos que a condicao permanecera ativa.
     */
    public Condicao(String nome, int duracao){
        this.nome = nome;
        this.duracao = duracao;
    }

    /**
     * Reduz em uma unidade a duracao restante da condicao atual.
     */
    public void diminuirDuracao(){
        duracao--;
    }

    /**
     * Verifica se o tempo de duracao da condicao chegou ao fim.
     *
     * @return true se a duracao for menor ou igual a zero, false caso contrario.
     */
    public boolean acabou(){
        return duracao<=0;
    }

    /**
     * Aplica o efeito especifico desta condicao no inimigo afetado a cada turno.
     *
     * @param alvo o inimigo que sofrera as consequencias da condicao.
     */
    public abstract void efeitoCondicao(Inimigo alvo);

    public String getNome(){
        return nome;
    }
}