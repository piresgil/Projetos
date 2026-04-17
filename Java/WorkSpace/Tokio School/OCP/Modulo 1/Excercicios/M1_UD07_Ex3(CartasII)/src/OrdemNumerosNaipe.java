import java.util.Comparator;
import java.util.List;

public class OrdemNumerosNaipe extends AlgoritmoOrdenacao implements Comparator<Carta> {

    @Override
    public List<Carta> ordena(List<Carta> listaCartas) {
        return List.of();
    }

    @Override
    public int compare(Carta c1, Carta c2) {
        // Comparação pelo número da carta (usando a ordem definida no array ORDEM_VALORES)
        int comparacaoNumero = Integer.compare(
                Baralho.ORDEM_NUMEROS.indexOf(c1.getNumero()),
                Baralho.ORDEM_NUMEROS.indexOf(c2.getNumero())
        );
        // Se os números forem iguais, compararemos pelo naipe
        if (comparacaoNumero != 0) {
            return comparacaoNumero;
        }
        // Comparação pelo naipe (usando a ordem definida no array ORDEM_NAIPES)
        return Integer.compare(
                Baralho.ORDEM_NAIPES.indexOf(c1.getNaipe()),
                Baralho.ORDEM_NAIPES.indexOf(c2.getNaipe())
        );
    }
}
