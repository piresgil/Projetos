package app;

import entities.Lutador;
import entities.herois.Batman;
import entities.herois.Superman;
import entities.herois.Thor;
import entities.viloes.Joker;
import entities.viloes.LexLuthor;
import entities.viloes.Loki;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("*** Bem-vindo ***");
        System.out.println("*** Super-Herois ***");
/*
        SuperHeroi heroi = new SuperHeroi(4000, 100, 75);
        System.out.println("*** Herói ***");
        System.out.println("HP: " + heroi.getPontosVida());
        System.out.println("Ataque: " + heroi.getAtaque());
        System.out.println("Defesa: " + heroi.getDefesa());

        Vilao vilao = new Vilao(2000, 150, 50);
        System.out.println("*** Vilão ***");
        System.out.println("HP: " + vilao.getPontosVida());
        System.out.println("Ataque: " + vilao.getAtaque());
        System.out.println("Defesa: " + vilao.getDefesa());

        // Superman heroi = new Superman();
           Batman heroi = new Batman();
        // Thor heroi = new Thor();


        // LexLuthor vilao = new LexLuthor();
           Joker vilao = new Joker();
        // Loki vilao = new Loki();

 */

        Lutador heroi;
        Lutador vilao;

        System.out.println("\nEscolha o primeiro Heroi:");
        heroi = personagem();

        System.out.println("\nEscolha o segundo Herói:");
        vilao = personagem();

        System.out.println("\n*** Combate ***");

        do {
            System.out.println("\nHerói Ataca ***");
            combate(heroi, vilao);

            System.out.println("\nVilão Ataca ***");
            combate(vilao, heroi);

            if (vilao.getPontosVida() <= 0) {
                System.out.print("\n***** Herói Ganhou ");
                System.out.println("********** " + heroi.getNome().toUpperCase() + " **********");

            } else if (heroi.getPontosVida() <= 0) {
                System.out.print("\n***** Vilão Ganhou ");
                System.out.println("********** " + vilao.getNome().toUpperCase() + " **********");
            }
        } while (heroi.getPontosVida() > 0 && vilao.getPontosVida() > 0);
    }

    public static Lutador personagem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Superman");
        System.out.println("2.Batman");
        System.out.println("3.Thor");
        System.out.println("4.Lex Luthor");
        System.out.println("5.Joker");
        System.out.println("6.Loki");
        int pj2 = sc.nextInt();

        switch (pj2) {
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
            default -> throw new IllegalStateException("Escolha Inválida: " + pj2);
        }
    }

    public static void combate(Lutador pj1, Lutador pj2) {
        int dano = pj1.atacar() - pj2.defender();
        System.out.println("Heroi (HP): " + pj1.getPontosVida());
        System.out.println("Vilão (HP): " + pj2.getPontosVida());
        pj2.obterVida(dano);
    }
}