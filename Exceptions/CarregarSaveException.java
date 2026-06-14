package Exceptions;

/**
 * Exceção que vai ser usada para propagar algum erro de carregamento de save
 */
public class CarregarSaveException extends RuntimeException {
    public CarregarSaveException(String message) {
        super(message);
    }
}
