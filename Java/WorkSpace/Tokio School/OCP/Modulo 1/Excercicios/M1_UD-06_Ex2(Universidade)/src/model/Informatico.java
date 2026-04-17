package model;

/**
 * Subclasse Informatico
 */
public class Informatico extends PAS {
    private static final int valorHora = 600; // 6 euros/hora em cêntimos
    private static final int horasSemana = 40;

    public Informatico(String cc, String nome, int horasExtras) {
        super(cc, nome, valorHora, horasSemana, horasExtras);
    }
}