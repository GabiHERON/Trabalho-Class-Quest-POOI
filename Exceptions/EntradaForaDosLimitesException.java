package Exceptions;

/**
 * Exceção usada pelo Scanner min max quando o valor está fora do escopo
 */
public class EntradaForaDosLimitesException extends RuntimeException {
    public EntradaForaDosLimitesException() {
        super("Escolha uma opção dentre as disponíveis!");
    }
}
