package Eventos.Loja;

import java.util.Scanner;
import Eventos.Evento;
import Geral.ScannerMinMax;
import Jogador.Personagem;
import java.util.HashMap;

/**
 * Representa o evento da loja no jogo, onde o jogador pode interagir com um menu
 * para visualizar, consultar informacoes e comprar itens consumiveis ou passivos
 * utilizando suas moedas.
 */
public class Loja implements Evento{
    private HashMap<String, EnumItens> catalogoItens;

    public Loja(){
        catalogoItens = new HashMap<>();
        for (EnumItens item : EnumItens.values()) {
            catalogoItens.put(item.getNome(), item);
        }
    }

    public void executar(Personagem jogador){
        System.out.println("Bem vindo à Loja Cabeça de Minotauro!");
        System.out.println("Deseja ver os itens à venda?\n[0]Sair da loja \n[1]Ver Itens ");

        ScannerMinMax scanner = new ScannerMinMax();
        int resposta = scanner.lerInteiro(0,1);

        EnumItens[] itensLoja = EnumItens.values();

        if(resposta == 1){

            int i = 1;

            System.out.println("Caso queira mais informações, digite o número do item desejado.");
            System.out.println("[0]Sair da loja ");
            for (EnumItens item : EnumItens.values()) {
                System.out.println("[" + i + "]"+"$"+item.getValorItem()+" "+item.getNome());
                i++;
            }


            int respostaItens = scanner.lerInteiro(0,itensLoja.length);

            if(respostaItens!=0) {
                String nomeItem = itensLoja[respostaItens-1].getNome();

                EnumItens itemSelecionado = catalogoItens.get(nomeItem);

                System.out.println(itemSelecionado.getNome() + ": " + itemSelecionado.getMensagem());
                System.out.println("Valor: " + itemSelecionado.getValorItem() + " moedas.");
                System.out.println("Deseja comprar? \n[0]Sim \n[1]Não ");


                int repostaCompra = scanner.lerInteiro(0, 1);

                if (repostaCompra == 0) {
                    if (jogador.getMoedas() >= itemSelecionado.getValorItem()) {
                        jogador.gastarMoedas(itemSelecionado.getValorItem());
                        jogador.adquirirItem(itemSelecionado.criarItem());
                        System.out.println("Item comprado com sucesso");
                    } else {
                        System.out.println("Seu pauper! Vá batalhar para conseguir mais moedas.");
                    }
                }
            }
        }
    }
}