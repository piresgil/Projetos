package model;

import java.util.ArrayList;

public class Universidade {
    private Pessoal[] pessoal = new ArrayList<>().toArray(new Pessoal[0]);

    public static double obterOrcamentoTotal(Pessoal[] listaPessoal) {
        double total = 0;
        for (Pessoal pessoa : listaPessoal) {
            total += pessoa.calcularSalarioTotal();
        }
    return total/100;
    }

    /*
     * Criar uma classe Universidade com uma função public static void
     * imprimirNominas(Pessoal[] listaPessoal) que imprima por ecrã,
     * para cada Pessoal incluído na listaPessoal, o nome do pessoal, a sua
     * categoria e o seu saldo.
     */
    public static void
    imprimirNominas(Pessoal[] listaPessoal) {
        for (Pessoal pessoa : listaPessoal) {
            System.out.println(pessoa);
        }
    }
}
