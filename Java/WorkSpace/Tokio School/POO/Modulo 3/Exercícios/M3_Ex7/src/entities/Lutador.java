package entities;

public interface Lutador {

    String nome="";

    int pontosVida = 0;
    int ataque = 0;
    int defesa = 0;

    int atacar();

    int defender();

    void obterVida(int dano);

    default String getNome(){
        return nome;
    }

    default int getPontosVida(){
        return pontosVida;
    }

}
