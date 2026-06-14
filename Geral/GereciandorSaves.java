package Geral;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Eventos.EnumEventos;
import Exceptions.CarregarSaveException;
import Jogador.Personagem;

/**
 * Classe com as funções que salvam e restauram um jogo
 */
public class GereciandorSaves {
    /**
     * Carrega os elementos do jogo quando o jogador está para escolher um evento
     * @param dadosJog Guarda todos dados do personagem e o último elemento contém o índice do evento atual
     * @param eventos Guarda os eventos que haviam sidos sorteados
     */
    public void carregarJogo(String[] dadosJog,ArrayList<EnumEventos> eventos) throws CarregarSaveException{
        Scanner scanner = new Scanner(System.in);
        try {
            BufferedReader br = new BufferedReader(new FileReader("save.txt"));
            String linha= br.readLine();
            String[] dados = linha.split(";");
            for(int i=0;i<dados.length;i++){
                dadosJog[i]=dados[i];
            }
            linha= br.readLine();
            String[] dadosEventos = linha.split(";");
            for (String ev : dadosEventos) {
                if (ev == null || ev.isBlank()) continue;
                eventos.add(EnumEventos.valueOf(ev.trim()));
            }
            br.close();
        }
        catch (FileNotFoundException e1){
            throw (new CarregarSaveException("Não existe nenhum jogo salvo, iniciando um novo jogo"));
        }
        catch (IOException e2){
            throw (new CarregarSaveException("Arquivo corrompido, iniciando um novo jogo"));
        }
    }

    /**
     * Salva todos os elementos da sessão num arquivo save.txt
     * @param jogador Objeto do jogador
     * @param eventos Os eventos que foram sorteados no momento do save
     * @param eventoAtual Índice do evento atual
     */
    public void salvarJogo(Personagem jogador,ArrayList<EnumEventos> eventos, Integer eventoAtual){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("save.txt"));
            bw.write(jogador.getNome()+";");
            bw.write(jogador.getNivel()+";");
            bw.write(jogador.getClasse()+";");
            bw.write(jogador.getMoedas()+";");
            bw.write(jogador.getVida()+";");
            bw.write(jogador.getMana()+";");
            bw.write(eventoAtual.toString());
            bw.newLine();
            for(EnumEventos evento:eventos){
                bw.write(evento+";");
            }
            bw.close();

        }
        catch (IOException e1){
            System.out.println(e1);
        }
    }
}
