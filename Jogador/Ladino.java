package Jogador;
import Geral.ScannerMinMax;
import Inimigos.Inimigo;
import Jogador.Magia.Curar;
import Jogador.Magia.Magia;

import java.util.ArrayList;

/**
 * Representa a classe especializada Ladino no jogo, que possui foco em atributos 
 * de velocidade, ataques multiplos baseados em rapidez e alta capacidade de fuga de combates.
 */
public class Ladino extends Personagem{

	ScannerMinMax scanner = new ScannerMinMax();

	/**
     * Construtor para criacao inicial de um personagem Ladino com seus atributos 
     * e magias padronizadas de nivel 1.
     *
     * @param nome o nome a ser atribuido ao Ladino.
     * @param classe o identificador numerico correspondente a esta classe.
     */
	public Ladino(String nome, int classe){
		super(nome, classe, new Atributos(2,2,5,4,2));
		setVidaMaxima(45);
		setManaMaxima(5);
		aprenderMagia(new Curar());
		setVida(getVidaMaxima());
		setMana(getManaMaxima());
	}

	/**
     * Construtor para restaurar o estado de um Ladino a partir de um vetor 
     * de dados vindos de um arquivo de save.
     *
     * @param dados o arranjo contendo as strings dos dados salvos do personagem.
     */
	public Ladino(String[] dados){
		super(dados, new Atributos(2,1,4,4,2));
		setVidaMaxima(45);
		setManaMaxima(5);
	}

	public void ataque(Inimigo alvo){
		int acertos = 0;
			for(int i = 0; i < getAtributos().getVelocidade(); i++){
				int resultado = rand.nextInt(6)+1;
				System.out.print("Dado "+ i + ": " + resultado);
				if(resultado == 6){
					System.out.print(" Acerto Rapido!");
					acertos++;
					i--;	
				}
				else if(resultado >= atributos.getMargemAcerto()){
					System.out.print(" Acerto!");
					acertos++;
				}
				System.out.print(" ");
			}
			System.out.println();
			alvo.tomarDano(acertos* atributos.getDanoAcerto());
			
	}

	public void magia(ArrayList<Inimigo> alvos){
		int i = 0;
		System.out.println("Qual magia deseja lancar?");
		for(i = 0; i < getListaMagias().size(); i++){
			System.out.print("[" + i + "] "+getListaMagias().get(i)+" ");
		}
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
		if(tentativas >= 2){
			System.out.println("Voce conseguiu fugir!");
			ganharMoedas(recompensa);
			return true;
		}
		else{
			System.out.println("Voce nao coseguiu fugir!");
			return false;
		}
	}
}