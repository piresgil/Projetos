package model;

/**
 * Subclasse Investigador
 */
public class Investigador extends PDI {
    private static final int valorHora = 700; // 7 euros/hora em cêntimos
    private static final int horasSemana = 35;

    public Investigador(String cc, String nome) {
        super(cc, nome, valorHora, horasSemana);
    }
}