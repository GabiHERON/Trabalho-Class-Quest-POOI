package Jogador;

/**
 * Gerencia os atributos fisicos, magicos e de precisao do personagem, 
 * controlando as alteracoes de dano e margem de acerto durante o jogo.
 */
public class Atributos {
    private int Forca, Poder, Velocidade;
    private int margemAcerto, danoAcerto;

    public Atributos(int forca, int poder, int velocidade, int margemAcerto, int danoAcerto){
        this.Forca = forca;
        this.Poder = poder;
        this.Velocidade = velocidade;
        this.margemAcerto = margemAcerto;
        this.danoAcerto = danoAcerto;
    }

    public int getForca() {
        return Forca;
    }

    public int getPoder() {
        return Poder;
    }

    public int getVelocidade() {
        return Velocidade;
    }

    public int getDanoAcerto() {
        return danoAcerto;
    }

    public int getMargemAcerto() {
        return margemAcerto;
    }

    /**
     * Incrementa o valor do dano causado por um acerto bem-sucedido.
     *
     * @param quantia a quantidade de dano a ser adicionada.
     */
    public void aumentarDano(int quantia){
        danoAcerto += quantia;
    }

    /**
     * Reduz o valor do dano causado por um acerto, garantindo que o 
     * resultado nao seja menor do que zero.
     *
     * @param quantia a quantidade de dano a ser subtraida.
     */
    public void reduzirDano(int quantia){
        if(danoAcerto-quantia>=0) {
            danoAcerto -= quantia;
        }
        else{
            danoAcerto=0;
        }
    }

    /**
     * Incrementa a margem de acerto do personagem, melhorando sua precisao.
     *
     * @param quantia a quantidade a ser somada a margem atual.
     */
    public void aumentarMargemAcerto(int quantia){
        margemAcerto += quantia;
    }

    /**
     * Reduz a margem de acerto do personagem, limitando o valor minimo a zero 
     * caso a reducao seja maior do que a margem atual.
     *
     * @param quantia a quantidade a ser subtraida da margem atual.
     */
    public void reduzirMargemAcerto(int quantia){
        if(margemAcerto-quantia>=0) {
            margemAcerto -= quantia;
        }
        else{
            margemAcerto=0;
        }
    }
}
