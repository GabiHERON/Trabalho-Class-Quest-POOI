package Jogador.Magia;

/**
 * Catalogo que define os tipos de magias disponiveis no jogo, 
 * associando cada constante ao seu nome textual correspondente.
 */
public enum EnumMagia {
    BOLA_DE_FOGO("Bola de Fogo"),CURAR("Curar"),
    RAJADA_MAGICA("Rajada Magica"),RAIO("Raio"),FRAQUEZA("Fraqueza");

    private String nome;
    private EnumMagia(String nome){
        this.nome = nome;
    }

    public String getNome(){return nome;}
}