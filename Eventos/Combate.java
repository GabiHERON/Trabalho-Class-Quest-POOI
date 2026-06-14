package Eventos;

import Geral.ScannerMinMax;
import Inimigos.Inimigo;
import Jogador.Personagem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe abstrata responsavel por gerenciar a estrutura de turnos e fluxo principal 
 * de um combate entre o jogador e um grupo de inimigos.
 */
public abstract class Combate {
    public void combate(Personagem jogador, ArrayList<Inimigo> inimigos, int recompensa){
        ScannerMinMax scanner = new ScannerMinMax();

        System.out.println(jogador);
        for(Inimigo inimigo:inimigos) {
            System.out.println(inimigo);
        }
        int rodada=1;
        boolean fugir = false;
        while(jogador.getVida()>0 && !inimigos.isEmpty() && !fugir){
            System.out.println("-----------Rodada "+rodada+"-----------");
            eventoRodada(rodada, inimigos);
            System.out.println("Selecione uma acao");
            for(int i = 0; i < 4; i++){
                System.out.print("[" + i + "] ");
                switch(i){
                    case 0:
                        System.out.print("Atacar ");
                        break;
                    case 1:
                        System.out.print("Magia ");
                        break;
                    case 2:
                        System.out.print("Fugir ");
                        break;
                    case 3:
                            System.out.println("Usar Item ");

                    default:
                        break;
                }
                System.out.print(" ");
            }
            System.out.println();
            int escolhaAcao =0;

            escolhaAcao= scanner.lerInteiro(0,3);


            switch(escolhaAcao){
                case 0:
                    System.out.println("Selecione um alvo");
                    for(int i=0;i<inimigos.size();i++){
                        System.out.print("["+i+"] "+inimigos.get(i)+" ");
                    }
                    System.out.println(" ");

                    int idxAlvo=scanner.lerInteiro(0,inimigos.size()-1);

                    jogador.ataque(inimigos.get(idxAlvo));
                    if(inimigos.get(idxAlvo).getVida()<=0){
                        inimigos.remove(idxAlvo);
                    }
                    break;
                case 1:
                    jogador.magia(inimigos);
                    for(int i=0;i<inimigos.size();i++){
                        if(inimigos.get(i).getVida()<=0){
                            inimigos.remove(i);
                        }
                    }
                    break;
                case 2:
                    fugir = jogador.fugir(recompensa);
                    break;
                case 3:
                    jogador.usarConsumivel();
                default:
                    break;
            }
            if(fugir){
                break;
            }

            for(Inimigo inimigo:inimigos){
                inimigo.ataque(jogador);
            }

            for(int i = 0; i<inimigos.size(); i++){
                inimigos.get(i).validarCondicao();
                if(inimigos.get(i).getVida()<=0){
                    inimigos.remove(i);
                }
            }

            System.out.println(jogador);
            for(Inimigo inimigo:inimigos) {
                System.out.println(inimigo);
            }
            rodada++;

        }
        jogador.fimConsumiveis();
        if(jogador.getVida()<=0){
            System.out.println("Jogador perdeu!");
        }
        else if (fugir){
            System.out.println("Jogador fugiu!");
        }
        else{
            System.out.println("Jogador Venceu!");
            jogador.ganharMoedas(recompensa);
        }

        jogador.restaurarMana();
    }

    /**
     * Metodo abstrato executado no inicio de cada rodada para disparar gatilhos 
     * ou eventos customizados especificos de cada combate.
     *
     * @param rodada o numero da rodada atual do combate.
     * @param inimigos a lista de inimigos presentes no combate.
     */
    public abstract void eventoRodada(int rodada, ArrayList<Inimigo> inimigos);
}