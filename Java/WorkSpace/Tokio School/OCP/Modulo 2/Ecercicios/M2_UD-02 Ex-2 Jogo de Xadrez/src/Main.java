import component.Tabuleiro;
import model.enuns.CorPeca;

/**
 * @author Daniel Gil
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem vindo ***");

        Tabuleiro tabuleiro = new Tabuleiro();
        System.out.println("Avaliação das brancas: " + tabuleiro.avalia(CorPeca.BRANCA));
        System.out.println("Avaliação das pretas: " + tabuleiro.avalia(CorPeca.PRETA));
        System.out.println("Avaliação do Tabuleiro: " + tabuleiro.avalia());
/*
        tabuleiro.TabuleiroBrancas();
        System.out.println("Avaliação das brancas: " + tabuleiro.avalia(CorPeca.BRANCA));
        System.out.println("Avaliação das pretas: " + tabuleiro.avalia(CorPeca.PRETA));
        System.out.println("Avaliação do Tabuleiro: " + tabuleiro.avalia());

        tabuleiro.TabuleiroPretas();
        System.out.println("Avaliação das brancas: " + tabuleiro.avalia(CorPeca.BRANCA));
        System.out.println("Avaliação das pretas: " + tabuleiro.avalia(CorPeca.PRETA));
        System.out.println("Avaliação do Tabuleiro: " + tabuleiro.avalia());

 */
    }
}