package entities;

import java.util.Random;

public class Carro {

    // Atributos da Class
    public static String vencedor;
    private String nome;
    private int velocidade;

    public Carro(String nome, int velocidade) {
        this.nome = nome;
        this.velocidade = velocidade;
    }

    public static String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        entities.Carro.vencedor = vencedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public double correr(double distancia) {
        // double tempo = distancia / (Math.random() * 0.5 * velocidade);
        //double velocidadeAleatoria = 0.5 * velocidade + (Math.random() * 0.5 * velocidade);
        double tempo = distancia / velocidade;

        return tempo;
    }
}
