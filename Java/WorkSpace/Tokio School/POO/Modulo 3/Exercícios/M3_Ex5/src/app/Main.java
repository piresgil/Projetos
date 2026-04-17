package app;

import entities.CartaoCredito;
import entities.FormaDePagamento;
import entities.PayPal;

public class Main {
    public static void main(String[] args) {

        System.out.println("*** Bem-vindo ***");
        System.out.println("*** Formas de Pagamento ***");

        FormaDePagamento formaDePagamento = new FormaDePagamento();

        CartaoCredito cartaoCredito = new CartaoCredito();
        PayPal payPal = new PayPal();

        formaDePagamento.processarPagamento();

        cartaoCredito.processarPagamento();
        payPal.processarPagamento();
    }
}