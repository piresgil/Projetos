package model;

/**
 * Subclasse Administrativo
 */
public class Administrativo extends PAS {
    private static final int valorHora = 750; // 7,5 euros/hora em cêntimos
    private static final int horasSemana = 37;

    public Administrativo(String cc, String nome, int horasExtras) {
        super(cc, nome, valorHora, horasSemana, horasExtras);
    }
}
