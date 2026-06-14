package Eventos.Loja;

/**
 * Catalogo de itens disponiveis na loja do jogo, definindo seus nomes, 
 * descricoes, valores em moedas e a logica de instanciacao de cada item.
 */
public enum EnumItens {
    ADAGA("Adaga", "Item feito no subsolo pelos especializados gnomos. Afiada e elegante, a Adaga dá ao jogador mais dano em seu ataque (+2).", 25), 
    ESCUDO("Escudo", "Item robusto produzido pelos centauros do norte, protegendo o jogador, o Escudo diminui 2 do dano dos ataques inimigos.", 25), 
    AMULETO_DA_SORTE("Amuleto da Sorte", "Item ancestral raríssimo, o Amuleto da Sorte concede ao jogador uma probabilidade maior de acertar seus ataques.", 50), 
    ELIXIR_REVITALIZADOR("Elixir Revitalizador", "Podendo ser usado apenas uma vez, o Elixir revitaliza a vida do usuário no máximo.", 10), 
    ELIXIR_FORCA("Elixir da Força", "Podendo ser usado apenas uma vez, o Elixir potencializa os ataques do jogador (+3).", 15),
    CHAPEU_ARCANO("Chapeu Arcano", "Chapeu antigo feito com couro de basilisco. O chapeu aumenta as capacidades do conjurador, aumentando a forca de suas magias(+2)",20),
    ELIXIR_MAGICO("Elixir Magico","Podendo ser usado apenas uma vez, o Elixir fortalece as magias do conjurador (+2)",15),
    ELIXIR_DE_MANA("Elixir de Mana", "Podendo ser usado apenas uma vez, o Elixir recupera a mana do usuário no máximo.",10);

    private String mensagem, nome;
    private int valorItem;

    private EnumItens(String nome, String mensagem, int valorItem){
        this.nome = nome;
        this.mensagem = mensagem;
        this.valorItem = valorItem;
    }

    public String getNome() {
        return nome;
    }

    public int getValorItem() {
        return valorItem;
    }

    public String getMensagem() {
        return mensagem;
    }

    /**
     * Fabrica e retorna uma nova instancia do objeto correspondente 
     * ao item selecionado no enum.
     *
     * @return a instancia concreta do Item criado ou null se nao corresponder a nenhum caso.
     */
    public Item criarItem(){
        Item item = null;
        switch (this){
            case ADAGA:
                item=new Adaga();
                break;
            case ESCUDO:
                item=new Escudo();
                break;
            case ELIXIR_FORCA:
                item=new ElixirDaForca();
                break;
            case AMULETO_DA_SORTE:
                item=new AmuletoDaSorte();
                break;
            case ELIXIR_REVITALIZADOR:
                item=new ElixirRevitalizador();
                break;
            case CHAPEU_ARCANO:
                item=new ChapeuArcano();
                break;
            case ELIXIR_MAGICO:
                item=new ElixirMagico();
                break;
            case ELIXIR_DE_MANA:
                item=new ElixirDeMana();
        }
        return item;
    }

}