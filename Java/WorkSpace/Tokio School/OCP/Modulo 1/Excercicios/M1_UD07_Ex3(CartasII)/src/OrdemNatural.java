import java.util.Comparator;
import java.util.List;

public class OrdemNatural extends AlgoritmoOrdenacao implements Comparator<Carta> {

    @Override
    public List<Carta> ordena(List<Carta> listaCartas) {
        return List.of();
    }

    @Override
    public int compare(Carta c1, Carta c2) {
        // Comparador de cartas usado no algoritmo de ordenacao natural
        // Comparação pelo número da carta (usando a ordem definida no array ORDEM_NAIPES)
        int comparacaoNaipe = Integer.compare(
                Baralho.ORDEM_NAIPES.indexOf(c1.getNaipe()),
                Baralho.ORDEM_NAIPES.indexOf(c2.getNaipe())
        );

        // Comparação pelo número da carta (usando a ordem definida no array ORDEM_VALORES)
        if (comparacaoNaipe != 0) return comparacaoNaipe;

        return Integer.compare(
                Baralho.ORDEM_NUMEROS.indexOf(c1.getNumero()),
                Baralho.ORDEM_NUMEROS.indexOf(c2.getNumero())
        );
    }
}
