package Jogador;
import Geral.ScannerMinMax;
import Inimigos.Inimigo;
import Jogador.Magia.*;

import java.util.ArrayList;

/**
 * Representa a classe especializada Mago no jogo, que possui foco em atributos 
 * de poder magico, vasta quantidade de mana e um grande repertorio de magias aprendidas.
 */
public class Mago extends Personagem{
	ScannerMinMax scanner = new ScannerMinMax();

	/**
     * Construtor para criacao inicial de um personagem Mago com seus atributos 
     * e o conjunto completo de magias iniciais de nivel 1.
     *
     * @param nome o nome a ser atribuido ao Mago.
     * @param classe o identificador numerico correspondente a esta classe.
     */
	public Mago(String nome, int classe){
		super(nome, classe, new Atributos(1,4,2,5,1));
		setVidaMaxima(30);
		setManaMaxima(20);
		aprenderMagia(new Curar());
		aprenderMagia(new RajadaMagica());
		aprenderMagia(new BolaDeFogo());
		aprenderMagia(new Raio());
		aprenderMagia(new Fraqueza());
		setVida(getVidaMaxima());
		setMana(getManaMaxima());
		
	}

	/**
     * Construtor para restaurar o estado de um Mago a partir de um vetor 
     * de dados vindos de um arquivo de save.
     *
     * @param dados o arranjo contendo as strings dos dados salvos do personagem.
     */
	public Mago(String[] dados){
		super(dados, new Atributos(1,4,2,5,1));
		setVidaMaxima(30);
		setManaMaxima(20);
	}

	public void ataque(Inimigo alvo){
		int acertos = 0;
		for(int i = 0; i < getAtributos().getForca(); i++){
			int resultado = rand.nextInt(6)+1;
			System.out.print("Dado "+ i + ": " + resultado);
			if(resultado >= getAtributos().getMargemAcerto()){
				acertos++;
			}
		}
		alvo.tomarDano(acertos*getAtributos().getDanoAcerto());
	}

	public void magia(ArrayList<Inimigo> alvos){
		int i = 0;
		System.out.println("Qual magia deseja lancar?");
		for(i = 0; i < getListaMagias().size(); i++){
			System.out.print("[" + i + "]"+getListaMagias().get(i) + " ");
		}
		System.out.println();
		int escolhaMagia = scanner.lerInteiro(0,i);
		Magia magiaEscolhida = getListaMagias().get(escolhaMagia);
		if(gastarMana(magiaEscolhida.getCusto())){
			magiaEscolhida.efeito(this, alvos);
		}
	}

	public boolean fugir(int recompensa){
		int tentativas = 0;
		for(int i = 0; i < getAtributos().getVelocidade(); i++){
			int resultado = rand.nextInt(6)+1;
			System.out.print("Dado "+ i + ": " + resultado);
			if(resultado >= 3){
				System.out.print(" Fugiu!");
				tentativas++;
			}
		}
		System.out.println();
		if(tentativas >= 3){
			System.out.println("Voce conseguiu fugir!");
			return true;
		}
		else{
			System.out.println("Voce nao coseguiu fugir!");
			return false;
		}
	}
}