package entities;

public class Carro extends Veiculo {
    protected int numeroPortas;

    public Carro(String marca, int ano, int numeroPortas) {
        super(marca, ano);
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    @Override
    public void apresentar() {
        System.out.println("Marca: " + marca + ", Ano: " + ano + ", Nr de portas: " + numeroPortas);
    }
}
