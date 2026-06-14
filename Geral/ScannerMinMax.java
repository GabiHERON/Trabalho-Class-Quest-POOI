package Geral;

import Exceptions.EntradaForaDosLimitesException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe utilitaria responsavel por gerenciar a leitura de dados do console,
 * garantindo que as entradas numericas estejam dentro de um intervalo especifico.
 */

public class ScannerMinMax {
    Scanner scanner = new Scanner(System.in);
    /**
     * Le um numero inteiro do console e valida se ele esta contido no intervalo
     * fechado entre o valor minimo e maximo fornecidos.
     *
     * @param min o valor inteiro minimo permitido.
     * @param max o valor inteiro maximo permitido.
     * @return o valor inteiro validado dentro dos limites estabelecidos.
     */
    public int lerInteiro(int min,int max){
        boolean leituraRealizada=false;
        int valorLido=0;
        while (!leituraRealizada) {
            try{
                valorLido = scanner.nextInt();
                scanner.nextLine();
                if(valorLido<min||valorLido>max){
                    throw new EntradaForaDosLimitesException();
                }
                leituraRealizada=true;
            }
            catch(EntradaForaDosLimitesException e1){
                System.out.println(e1);
            }
            catch(InputMismatchException e2){
                System.out.println("Insira uma entrada válida!");
                scanner.nextLine();
            }
        }
        return valorLido;
    }
    /**
     * Finaliza o ciclo de vida do objeto Scanner guardado,
     * liberando os recursos do sistema.
     */
    public void encerrar(){
        scanner.close();
    }
}