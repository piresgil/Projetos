import entities.ContaBancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class M3_Ex6 {
    public static void main(String[] args) {

        System.out.println("*** Ben-vendo ***");
        System.out.println("*** Conta Bancária ***");

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nr Conta: ");
            int nrConta = sc.nextInt();
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Saldo: ");
            double saldo = sc.nextDouble();

            ContaBancaria contaBancaria = new ContaBancaria(nrConta, nome, saldo);
            System.out.println(contaBancaria);

            System.out.print("\nEfetue um depósito: ");
            double deposito = sc.nextDouble();
            contaBancaria.deposito(deposito);
            contaBancaria.verificarSaldo();

            System.out.print("\nEfetue um levantamento: ");
            double levantamento = sc.nextDouble();
            contaBancaria.levantar(levantamento);
            contaBancaria.verificarSaldo();


        } catch (InputMismatchException e) {
            System.out.println("Erro de digitação!");
        } finally {
            sc.close();
            System.out.println("*** Sair ***");
        }
    }

    public static class ContaBancaria {

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

        @Override
        public String toString() {
            return "\nNumero de Conta: " + numeroConta +
                    "\nNome: " + nome + '\'' +
                    "\nSaldo: " + saldo;
        }
    }
}