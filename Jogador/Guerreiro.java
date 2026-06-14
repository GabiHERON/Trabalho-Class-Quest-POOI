package Jogador;

import Inimigos.Inimigo;
import Jogador.Magia.*;
import Geral.*;
import java.util.ArrayList;

/**
 * Representa a classe especializada Guerreiro no jogo, que possui foco em atributos 
 * de forca, alta durabilidade de vida e mecanicas de combate baseadas em acertos criticos.
 */
public class Guerreiro extends Personagem{
	ScannerMinMax scanner = new ScannerMinMax();
	
	/**
     * Construtor para criacao inicial de um personagem Guerreiro com seus atributos 
     * e magias padronizadas de nivel 1.
     *
     * @param nome o nome a ser atribuido ao Guerreiro.
     * @param classe o identificador numerico correspondente a esta classe.
     */
	public Guerreiro(String nome, int classe){
		super(nome, classe, new Atributos(4,1,2,3,6));
		setVidaMaxima(60);
		setManaMaxima(5);
		aprenderMagia(new Curar());
		setVida(getVidaMaxima());
		setMana(getManaMaxima());
	}

	/**
     * Construtor para restaurar o estado de um Guerreiro a partir de um vetor 
     * de dados vindos de um arquivo de save.
     *
     * @param dados o arranjo contendo as strings dos dados salvos do personagem.
     */
	public Guerreiro(String[] dados){
        super(dados, new Atributos(4,1,2,3,4));
		setVidaMaxima(60);
		setManaMaxima(5);
    }

	public void ataque(Inimigo alvo){
		int acertos = 0;
		boolean critico = false;
		for(int i = 0; i < getAtributos().getForca(); i++){
			int resultado = rand.nextInt(6)+1;
			System.out.print("Dado "+ i + ": " + resultado);
			if(resultado == 6){
				System.out.print(" Acerto Critico!");
				acertos++;
				critico = true;
			}
			else if(resultado >= atributos.getMargemAcerto()){
				System.out.print(" Acerto");
				acertos++;
			}
			System.out.print(";");
		}
		System.out.println();
		if(critico){
			alvo.tomarDano(atributos.getDanoAcerto()*2 + acertos*2);
		}
		else{
			alvo.tomarDano(atributos.getDanoAcerto() + acertos*2);
		}
	}

	public void magia(ArrayList<Inimigo> alvos){
		int i = 0;
		System.out.println("Qual magia deseja lancar?");
		for(i = 0; i < getListaMagias().size(); i++){
			System.out.print("[" + i + "] "+getListaMagias().get(i) + " ");
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
				System.out.print(" Acerto!");
				tentativas++;
			}
			System.out.print(" ");
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