package model;

/**
 * Subclasse PDI
 */
public abstract class PDI extends Pessoal {

    public PDI(String cc, String nome, int valorHora, int horasSemana) {
        super(cc, nome, valorHora, horasSemana);
    }

    @Override
    public int calcularSalarioTotal() {
        return calcularSalarioBase();
    }
}