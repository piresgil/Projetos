import java.util.InputMismatchException;
import java.util.Scanner;

public class M3_Ex7 {

    public static void main(String[] args) {

        System.out.println("*** Bem-vindo ***");
        System.out.println("*** Super-Herois ***");

        Lutador heroi;
        Lutador vilao;

        System.out.println("\nEscolha o Heroi:");
        heroi = personagem();

        System.out.println("\nEscolha o Vilão:");
        vilao = personagem();

        atualizaHP(heroi, vilao);

        System.out.println("\n*** Combate ***\n");

        do {
            System.out.print("Herói (" + heroi.getNome() + ") - " + "Ataca ***");
            combate(heroi, vilao);
            System.out.print("Vilão (" + vilao.getNome() + ") - " + "Ataca ***");
            combate(vilao, heroi);

            atualizaHP(heroi, vilao);

            if (heroi.getPontosVida() <= 0 && vilao.getPontosVida() <= 0) {
                System.out.println("\n***** EMPATE *****");
            } else if (vilao.getPontosVida() <= 0) {
                System.out.print("\n***** Herói Ganhou ");
                System.out.println("********** " + heroi.getNome().toUpperCase() + " **********");

            } else if (heroi.getPontosVida() <= 0) {
                System.out.print("\n***** Vilão Ganhou ");
                System.out.println("********** " + vilao.getNome().toUpperCase() + " **********");
            }

        } while (heroi.getPontosVida() > 0 && vilao.getPontosVida() > 0);
    }

    /*
     * Metodos da class principal
     */
    // Metodo para escolha de um Lutador
    public static Lutador personagem() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1.Superman");
        System.out.println("2.Batman");
        System.out.println("3.Thor");
        System.out.println("4.Lex Luthor");
        System.out.println("5.Joker");
        System.out.println("6.Loki");
        int pj = sc.nextInt();

        switch (pj) {
            case 1 -> {
                return new Superman();
            }
            case 2 -> {
                return new Batman();
            }
            case 3 -> {
                return new Thor();
            }
            case 4 -> {
                return new LexLuthor();
            }
            case 5 -> {
                return new Joker();
            }
            case 6 -> {
                return new Loki();
            }
            default -> throw new IllegalStateException("Escolha Inválida: " + pj);
        }
    }

    // Metodo para combate entre Lutadores
    public static void combate(Lutador pj1, Lutador pj2) {
        int dano = pj1.atacar() - pj2.defender();
        pj2.obterVida(dano);
    }

    // Metodo que actualiza o HP dos Lutadores
    public static void atualizaHP(Lutador heroi, Lutador vilao) {
        System.out.println("\n*** HP ***");
        System.out.println("Herói (" + heroi.getNome() + "), " + heroi.getPontosVida() + " HP");
        System.out.println("Vilão (" + vilao.getNome() + "), " + vilao.getPontosVida() + " HP");
    }
}

/*
 * Interface para Lutador
 */
interface Lutador {

    String nome = "";

    int pontosVida = 0;
    int ataque = 0;
    int defesa = 0;

    int atacar();

    int defender();

    void obterVida(int dano);

    default String getNome() {
        return nome;
    }

    default int getPontosVida() {
        return pontosVida;
    }
}

/*
 * Class Personagem
 *
 * Class mais generica que define uma Personagem que atende á interface lutator e define alguns metodos
 */
class Personagem implements Lutador {

    private String nome;

    private int pontosVida;
    private int ataque;
    private int defesa;

    public Personagem() {

    }

    public Personagem(String nome, int pontosVida, int ataque, int defesa) {
        this.nome = nome;
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
        System.out.print(" (Ataque: " + ataque);
        return ataque;
    }

    @Override
    public int defender() {
        System.out.println(", Defesa: " + defesa + ")");
        return defesa;
    }

    @Override
    public void obterVida(int dano) {
        setPontosVida(pontosVida - dano);
    }
}

/*
 * Personagens
 *
 * Heranças da class Personagem
 */
class Superman extends Personagem {
    public Superman() {
        super("Superman", 4000, 100, 75);
    }
}

class Batman extends Personagem {
    public Batman() {
        super("Batman", 3000, 100, 75);
    }
}

class Thor extends Personagem {
    public Thor() { super("Thor", 2000, 100, 75); }
}

class LexLuthor extends Personagem {
    public LexLuthor() {
        super("Lex Luthor", 2500, 150, 50);
    }
}

class Joker extends Personagem {
    public Joker() {
        super("Joker", 2000, 150, 50);
    }
}

class Loki extends Personagem {
    public Loki() {
        super("Loki", 1500, 150, 50);
    }
}