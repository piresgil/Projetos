/**
 * @author Daniel Gil
 */

import java.util.List;
/**
 * Class ordenação nr incremental, naipe
 */
public class OrdNumIncPal extends AlgoritmoOrdenacao {

    @Override
    public List<Carta> ordena(List listaCartas) {
        // Algoritmo de ordenacao
        // Algoritmo bubble sort
        for (int i = 0; i < listaCartas.size() - 1; i++) {
            for (int j = 0; j < listaCartas.size() - 1 - i; j++) {
                Carta c1 = (Carta) listaCartas.get(j);
                Carta c2 = (Carta) listaCartas.get(j + 1);

                // Comparação e troca
                if (comparadorCarta(c1, c2) > 0) {
                    listaCartas.set(j, c2); // Coloca c2 no lugar de c1
                    listaCartas.set(j + 1, c1); // Coloca c1 no lugar de c2
                }
            }
        }
        return listaCartas;
    }


    public static int comparadorCarta(Carta c1, Carta c2) {
        // Comparador de cartas usado no algoritmo de ordenacao
        // com base na ordenacao passada no exercício
        int numeroComparacao = Integer.compare(
                ORDEM_NUMEROS.indexOf(c1.getNumero()),
                ORDEM_NUMEROS.indexOf(c2.getNumero()));

        if (numeroComparacao != 0) {
            return numeroComparacao; // Retorna o resultado da comparação de números
        }

        // Comparação por naipe
        return Integer.compare(
                ORDEM_NAIPES.indexOf(c1.getNaipe()),
                ORDEM_NAIPES.indexOf(c2.getNaipe()));
    }

}
