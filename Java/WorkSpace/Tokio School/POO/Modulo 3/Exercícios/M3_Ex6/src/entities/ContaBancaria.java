package entities;

public class ContaBancaria {

    private int numeroConta;
    private String nome;
    private double saldo;

    public ContaBancaria(int numeroConta, String nome, double saldo) {
        this.numeroConta = numeroConta;
        this.nome = nome;
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public void deposito(double quantidade) {
        this.saldo += quantidade;
    }

    public void levantar(double quantidade) {
        this.saldo -= quantidade;
    }

    public void verificarSaldo() {
        System.out.println("Saldo: " + saldo);
    }
}
