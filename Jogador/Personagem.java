package Jogador;

import Eventos.Loja.Item;
import Geral.ScannerMinMax;
import Inimigos.Inimigo;
import Jogador.Magia.Magia;

import java.util.ArrayList;
import java.util.Random;


/**
 * Contém a base do funcionamento do personagem que será implementada pelas classes de classe do rpg
 */
public abstract class Personagem {
    private String nome;
    private int moedas = 10;
    private int nivel;
    private int classe;
    private int vida;
    private int mana;
    private int vidaMaxima;
    private int manaMaxima;
    private int armadura = 0;
    private ArrayList<Magia> listaMagias = new ArrayList<>();
    private int forcaMagia = 0;

    ArrayList<Item> itensPassivos = new ArrayList<>();
    ArrayList<Item> itensConsumiveis = new ArrayList<>();
    ArrayList<Item> consumiveisUsados = new ArrayList<>();


    // Atributos.
    Atributos atributos;

    Random rand = new Random();

    /**
     * Construtor geral do personagem, para primeira construção
     */
    public Personagem(String nome, int classe, Atributos atributos) {
        this.nome = nome;
        this.classe = classe;
        this.atributos = atributos;
        nivel = 1;
        vida = vidaMaxima;
    }

    /**
     * Construtor para restaurar um personagem através de um arquivo de save
     *
     * @param dados contem os dados recuerados do arquivo de save
     */
    public Personagem(String[] dados, Atributos atributos) {
        nome = dados[0];
        nivel = Integer.parseInt(dados[1].trim());
        classe = Integer.parseInt(dados[2].trim());
        moedas = Integer.parseInt(dados[3].trim());
        vida = Integer.parseInt(dados[4].trim());
        mana = Integer.parseInt(dados[5].trim());
        this.atributos=atributos;
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getClasse() {
        return classe;
    }

    public int getMoedas() {
        return moedas;
    }

    public Atributos getAtributos() {
        return atributos;
    }

    public void aprenderMagia(Magia magia){
        listaMagias.add(magia);
    }
    public ArrayList<Magia> getListaMagias(){
        return listaMagias;
    }

    public void ganharMoedas(int qtd) {
        moedas = moedas + qtd;
    }

    public void gastarMoedas(int qtd) {
        moedas -= qtd;
    }

    public int getVida() {
        return vida;
    }
    public int getVidaMaxima(){return vidaMaxima;}

    public int getMana() {return mana;}
    public int getManaMaxima(){return manaMaxima;}
    public boolean gastarMana(int quantia){
        if(mana >= quantia){
            mana-=quantia;
            return true;
        }
        else{
            System.out.println("Mana Insuficiente!");
            return false;
        }
    }

    public int getForcaMagia(){
        return forcaMagia;
    }
    public void ganharForcaMagia(int quantia){
        forcaMagia += quantia;
    }
    public void reduzirForcaMagia(int quantia){
        if(forcaMagia-quantia>=0) {
            forcaMagia -= quantia;
        }
        else{
            forcaMagia=0;
        }
    }

    public void setVida(int novoValor) {vida = novoValor;}
    public void setMana(int novoValor){mana = novoValor;}

    public void setVidaMaxima(int novoValor) {vidaMaxima = novoValor;}
    public void setManaMaxima(int novoValor) {manaMaxima = novoValor;}

    /**
     * Restaura a vida da vida ao máximo
     */
    public void restaurarVida(){
        vida=vidaMaxima;
    }

    public void restaurarMana(){
        mana = manaMaxima;
    }

    /**
     * Adiciona uma quantidade de vida ao jogador sem passar o máximo
     */
    public void recuperarVida(int quantia){
        if(vida+quantia > vidaMaxima){
            vida = vidaMaxima;
        }
        else{
            vida+=quantia;
        }
    }

    public abstract void ataque(Inimigo alvo);
    public abstract void magia(ArrayList<Inimigo> alvos);
    public abstract boolean fugir(int recompensa);

    /**
     * Função para diminuir uma quantia fixa da vida do jogador
     * @param qtdDano
     */
    public void tomarDano(int qtdDano){
        int qtdDanoReal = qtdDano - armadura;
        if(vida<qtdDanoReal){
            vida=0;
        }
        else{
            vida-=qtdDanoReal;
        }
    }

    public void aumentarDano(int quantia){
        atributos.aumentarDano(quantia);
    }

    public void reduzirDano(int quantia){
        atributos.reduzirDano(quantia);
    }

    public void aumentarMargemAcerto(int quantia){
        atributos.aumentarMargemAcerto(quantia);

    }

    public void reduzirMargemAcerto(int quantia){
        atributos.reduzirMargemAcerto(quantia);
    }

    public void ganharArmadura(int quantia){
        armadura+=quantia;
    }

    public void reduzirArmadura(int quantia){
        if(armadura-quantia>=0) {
            armadura -= quantia;
        }
        else{
            armadura=0;
        }
    }

    public void adquirirItem(Item item){
        if(item.isPassivo()){
            itensPassivos.add(item);
            item.efeito(this);
        }
        else{
            itensConsumiveis.add(item);
        }
    }

    public void usarConsumivel(){
        ScannerMinMax scanner = new ScannerMinMax();
        if(itensConsumiveis.isEmpty()){
            System.out.println("Mochila Vazia! Voce nao tem itens para usar.");
            return;
        }
        int escolha=0;
        System.out.println("Escolha qual item quer usar: ");
        for(int i=0;i<itensConsumiveis.size();i++){
            System.out.print("["+i+"]"+itensConsumiveis.get(i)+" ");
        }
        System.out.println();
        escolha=scanner.lerInteiro(0,itensConsumiveis.size()-1);
        itensConsumiveis.get(escolha).efeito(this);
        consumiveisUsados.add(itensConsumiveis.get(escolha));
        itensConsumiveis.remove(escolha);
    }

    public ArrayList<Item> getItensConsumiveis(){
        return itensConsumiveis;
    }

    public void fimConsumiveis(){
        for(Item item:consumiveisUsados){
            item.perderEfeito(this);
        }
        consumiveisUsados.clear();
    }

    public ArrayList<Item> getItensPassivos(){
        return itensPassivos;
    }

    @Override
    public String toString(){
        return nome+ "\nVida: "+vida+"/"+vidaMaxima+"\nMana: "+mana + "/" + manaMaxima;
    }
}