package Eventos;

/**
 * Catalogo que define todos os tipos de eventos disponiveis no mapa do jogo,
 * associando cada constante a sua mensagem de exibicao correspondente.
 */
public enum EnumEventos {
    CAVERNA_DOS_GOBLINS("Caverna dos Goblins"),
    FOGUEIRA("Fogueira"),
    LOJA("Loja"),
    BAU_DO_TESOURO("Baú do Tesouro"),
    FLORESTA_ESCURA("Floresta Escura"),
    LAGO_ENCANTADO("Lago Encantado");

    private String msg;
    private EnumEventos(String msg){
        this.msg=msg;
    }
    public String getMensagem(){
        return msg;
    }
}
