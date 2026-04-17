package entities;

public class Personagem implements Lutador {

    private String nome;

    private int pontosVida;
    private int ataque;
    private int defesa;

    public Personagem(){

    }
    public Personagem(String nome, int pontosVida, int ataque, int defesa) {
        this.nome=nome;
        this.pontosVida = pontosVida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    @Override
    public int atacar() {
        System.out.println("Ataque: " + ataque);
        return ataque;
    }

    @Override
    public int defender() {
        System.out.println("Defesa: " + defesa);
        return defesa;
    }

    @Override
    public void obterVida(int dano) {
        setPontosVida(pontosVida - dano);
    }
}
