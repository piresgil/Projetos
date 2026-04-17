import java.util.Arrays;
import java.util.List;

public abstract class AlgoritmoOrdenacao {
    // Listas ordenadas
    public static final List<String> ORDEM_NAIPES = Arrays.asList("PAUS", "COPAS", "ESPADAS", "OUROS");
    public static final List<String> ORDEM_NUMEROS = Arrays.asList("DOIS", "TRES", "QUATRO",
            "CINCO", "SEIS", "SETE", "VALETE", "RAINHA", "REI", "AS");
    /**
     * Ordena uma lista de cartas recibo por parametro
     *
     * @param listaCartas Lista de cartas que fica ordenada no final do algoritmo
     */
    public List<Carta> ordena(List listaCartas) {
        //TODO: Para implementar
         return listaCartas;
    }
}