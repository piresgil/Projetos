package model;

/**
 * Subclasse Professor
 */
public class Professor extends PDI {

    private static final int valorHora = 800; // 8 euros/hora em cêntimos
    private static final int horasSemana = 37;
    private int sexenios;

    public Professor(String cc, String nome, int sexenios) {
        super(cc, nome, valorHora, horasSemana);
        this.sexenios = Math.min(sexenios, 6); // Máximo de 6 sexénios
    }

    @Override
    public int calcularSalarioTotal() {
        return calcularSalarioBase() + sexenios * 10000; // 100 euros/sexênio em cêntimos
    }
}



