package entities;

public class Conta {

    private String titular;
    private int numeroConta;
    private double quantidade;

    public Conta(String titular, int numeroConta, double quantidade) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.quantidade = quantidade;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Numero de Conta: " + numeroConta +
                ", Titular: " + titular +
                ", Quantidade: " + quantidade;
    }
}
