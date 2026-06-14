package Inimigos;
import Jogador.Magia.Condicao.*;
import Jogador.Personagem;
import java.util.*;

/**
 * Implementacao base que define os comportamentos, atributos e gerenciamento 
 * de estados (condicoes) de um inimigo no jogo.
 */
public abstract class Inimigo {
    private String nome;
    private int vida;
    private int vidaMaxima;
    private int danoBase;
    private int danoFinal;
    private ArrayList<Condicao> condicoes = new ArrayList <>();

    /**
     * Construtor para inicializar um novo inimigo com seus atributos basicos.
     *
     * @param nome o nome a ser atribuido ao inimigo.
     * @param vida a quantidade de pontos de vida inicial (e maxima) do inimigo.
     * @param danoBase o dano base do inimigo.
     */
    public Inimigo(String nome, int vida , int danoBase){
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.danoBase = danoBase;
    }

    /**
     * Adiciona uma nova condicao (efeito de status) a lista de efeitos ativos do inimigo.
     *
     * @param condicao a condicao a ser aplicada ao inimigo.
     */
    public void adicionarCondicao(Condicao condicao){
        condicoes.add(condicao);
    }

    /**
     * Verifica se o inimigo esta atualmente sob o efeito de uma classe especifica de condicao.
     *
     * @param cond a classe da condicao que se deseja verificar (Ex: Fraco.class).
     * @return true se o inimigo possuir a condicao ativa, false caso contrario.
     */
    public boolean verificarCondicao(Class<? extends Condicao> cond){
        for(Condicao c: condicoes){
            if(cond.isInstance(c)){
                return true;
            }
        }
        return false;
    }

    /**
     * Processa os efeitos de todas as condicoes ativas, atualiza suas duracoes 
     * e remove aquelas que chegaram ao fim.
     */
    public void validarCondicao(){
        Iterator<Condicao> i = condicoes.iterator();

        while(i.hasNext()){
            Condicao cond = i.next();

            cond.efeitoCondicao(this);
            cond.diminuirDuracao();
            if(cond.acabou()){
               i.remove();
            }
;        }
    }
    /**
     * Processa o dano recebido pelo Inimigo
     * @param qtdDano representa o dano causado ao alvo
     */
    public void tomarDano(int qtdDano) {
        vida -= qtdDano;
    }

    /**
     * Calcula o dano final causado pelo inimigo, reduzindo o valor pela metade 
     * caso ele esteja sob a condicao de enfraquecimento (Fraco).
     *
     * @return o valor do dano final calculado.
     */
    private int getDanoFinal(){
        int dano = danoBase;
        if(verificarCondicao(Fraco.class)){
            dano = dano*3/4;
        }
        return dano;
    }

    /**
     *
     */

    public ArrayList<Condicao> getCondicoes(){
        return condicoes;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima(){
        return vidaMaxima;
    }

    public void ataque(Personagem alvo) {
        if(verificarCondicao(Paralisado.class)){
            return;
        }
        alvo.tomarDano(getDanoFinal());
    }

    public void recuperarVida(int quantia){
        if(vida+quantia > vidaMaxima){
            vida = vidaMaxima;
        }
        else{
            vida+=quantia;
        }
    }
    public String getNome() {
        return nome;
    }
}