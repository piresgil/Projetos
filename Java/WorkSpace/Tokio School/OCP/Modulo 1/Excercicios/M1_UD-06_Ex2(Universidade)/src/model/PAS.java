package model;

/**
 * Subclasse PAS
 */
public abstract class PAS extends Pessoal {
    protected int horasExtras = 0;

    public PAS(String cc, String nome, int valorHora, int horasSemana, int horasExtras) {
        super(cc, nome, valorHora, horasSemana);
        this.horasExtras = horasExtras;
    }

    @Override
    public int calcularSalarioTotal() {
        // return calcularSalarioBase();// 600 cent €
        return calcularSalarioBase() + (horasExtras * 600);// 600 cent €
    }
}


