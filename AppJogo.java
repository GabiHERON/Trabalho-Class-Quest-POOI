import Eventos.*;
import Eventos.Loja.Item;
import Eventos.Loja.Loja;
import Exceptions.CarregarSaveException;
import Geral.GereciandorSaves;
import Geral.ScannerMinMax;
import Jogador.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * Classe principal do sistema Class Quest.
 * Gerencia o fluxo de inicializacao do jogo, carregamento de progresso,
 * criacao de personagens e o loop principal de eventos do RPG.
 */
public class AppJogo {

    /**
     * Ponto de entrada do programa. Executa o menu inicial e controla 
     * a alternancia de turnos e eventos ate o fim do jogo ou acao de salvar.
     *
     * @param args argumentos de linha de comando (nao utilizados).
     */
    public static void main(String[] args){
        ScannerMinMax scanner = new ScannerMinMax();

        GereciandorSaves saves = new GereciandorSaves();

        int qtdEventosSorteados=3;

        Personagem jogador = null;
        int eventoAtual=0;
        ArrayList<EnumEventos> eventosSorteados = new ArrayList<>();

        int escolhaMenu=0;
        System.out.println("Escolha uma opção:");
        System.out.println("[0]Novo Jogo [1]Carregar Jogo Salvo");
        escolhaMenu=scanner.lerInteiro(0,1);

        if(escolhaMenu==0) {
            jogador = criarPersonagem();
        }
        else{
            try{
                String[] dadosJogador = new String[7];
                saves.carregarJogo(dadosJogador,eventosSorteados);
                eventoAtual=Integer.parseInt(dadosJogador[6].trim());
                int classePersonagem = Integer.parseInt(dadosJogador[2]);
                switch(classePersonagem){
                        case 0:
                            jogador = new Guerreiro(dadosJogador);
                            break;
                        case 1:
                            jogador = new Mago(dadosJogador);
                            break;
                        case 2:
                            jogador = new Ladino(dadosJogador);
                            break;
                        default:
                            System.out.println("Dado Invalido!");
                            break;
                }
            }
            catch (CarregarSaveException e1){
                System.out.println(e1);
                jogador = criarPersonagem();
            }
        }

        boolean encerrar=false;
        while(eventoAtual<10&&!encerrar) {
            
            System.out.println("------------Evento "+eventoAtual+"------------");
            System.out.println(jogador);
            System.out.println("Moedas: " + jogador.getMoedas());
            for(Item item:jogador.getItensPassivos()){
                System.out.println(item);
            }
            if(eventosSorteados.isEmpty()) {
                sortearEventos(eventosSorteados);
            }

            System.out.println("Escolha um evento:");
            for (int i = 0; i < qtdEventosSorteados; i++) {
                System.out.print("[" + i + "]" + eventosSorteados.get(i).getMensagem()+" ");
            }
            System.out.println("["+qtdEventosSorteados+"]Salvar e sair");

            int escolhaEvento=scanner.lerInteiro(0,qtdEventosSorteados);

            if(escolhaEvento!=qtdEventosSorteados) {
                Evento eventoEscolhido;
                switch (eventosSorteados.get(escolhaEvento)) {
                    case LOJA:
                        eventoEscolhido = new Loja();
                        break;
                    case FOGUEIRA:
                        eventoEscolhido = new Fogueira();
                        break;
                    case CAVERNA_DOS_GOBLINS:
                        eventoEscolhido = new CavernaDosGoblins();
                        break;
                    case BAU_DO_TESOURO:
                        eventoEscolhido = new BauDoTesouro();
                        break;
                    case FLORESTA_ESCURA:
                        eventoEscolhido = new FlorestaEscura();
                        break;
                    case LAGO_ENCANTADO:
                        eventoEscolhido = new LagoEncantado();
                        break;
                    default:
                        eventoEscolhido = new Fogueira();
                        break;
                }

                eventoEscolhido.executar(jogador);
                eventosSorteados.clear();
                if(jogador.getVida()<=0){
                    encerrar=true;
                }
            }
            else{
                encerrar=true;
                saves.salvarJogo(jogador,eventosSorteados,eventoAtual);
            }
            eventoAtual++;
        }
        if(jogador.getVida()>0&&!encerrar){
            System.out.println("------------Evento 10------------");
            System.out.println("[0] Provação Final [1]Salvar e sair");
            int escolhaEvento =scanner.lerInteiro(0,1);
            eventosSorteados.add(EnumEventos.FOGUEIRA);
            if(escolhaEvento==0){
                Evento provacaoFinal = new CemiterioDoMal();
                provacaoFinal.executar(jogador);
                if(jogador.getVida()<=0){
                    System.out.println("Mais sorte na próxima vez!");
                }
                else{
                    System.out.println("Parabéns você completou Class Quest!");
                    
                }
            }
            else{
                saves.salvarJogo(jogador,eventosSorteados,eventoAtual);
            }
        }
        scanner.encerrar();
    }

    /**
     * Função dedicada a sortear 3 eventos dos disponíveis na forma de Enum
     * @param eventosSorteados local onde são guardados esses eventos
     */
    public static void sortearEventos(ArrayList<EnumEventos> eventosSorteados){
        Random random = new Random();

        EnumEventos[] valoresEventos = EnumEventos.values();
        int qtdEventos = valoresEventos.length;

        ArrayList<EnumEventos> eventosPossiveis = new ArrayList<>();
        for (int i=0;i<qtdEventos;i++){
            eventosPossiveis.add(valoresEventos[i]);
        }

        for (int i = 0; i < 3; i++) {
            int sorteio=random.nextInt(qtdEventos-i);
            eventosSorteados.add(eventosPossiveis.get(sorteio));
            eventosPossiveis.remove(sorteio);
        }

    }
    
    /**
     * Função criada para organizar a parte de criação do jogador em um único bloco
     * @return Retorna o personagem pronto
     */
    public static Personagem criarPersonagem(){
        Scanner scanner = new Scanner(System.in);
        ScannerMinMax scannerMinMax = new ScannerMinMax();
        Personagem jogadorAux = null;
        System.out.println("Dê um nome ao seu herói:");
        String nomePersonagem = scanner.nextLine();
        while(jogadorAux == null){
            System.out.println("Escolha a classe do seu herói:");
            System.out.println("[0] Guerreiro  [1] Mago  [2]Ladino");
            int classeEscolhida=scannerMinMax.lerInteiro(0,2);
           
            switch(classeEscolhida){
                    case 0:
                        jogadorAux = new Guerreiro(nomePersonagem, classeEscolhida);
                        break;
                    case 1:
                        jogadorAux = new Mago(nomePersonagem, classeEscolhida);
                        break;
                    case 2:
                        jogadorAux = new Ladino(nomePersonagem, classeEscolhida);
                        break;
                    default:
                        System.out.println("Escolha Invalida!");
                        break;
                }
        }
        return jogadorAux;
    }

}