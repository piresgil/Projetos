import java.util.InputMismatchException;
import java.util.Scanner;

public class M3_Ex5 {
    public static void main(String[] args) {

        System.out.println("*** Bem-vindo ***");
        System.out.println("*** Formas de Pagamento ***");

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Escolha uma forma de pagamento");
            System.out.println("1.Cartão de Crédito");
            System.out.println("2.Paypal");
            int escolha = sc.nextInt();

            if (escolha == 1) {
                System.out.println("*** Cartão de Crédito ***");

                CartaoCredito cartaoCredito = new CartaoCredito();
                cartaoCredito.processarPagamento();
            }
            if (escolha == 2) {
                System.out.println("*** PayPal ****");

                PayPal payPal = new PayPal();
                payPal.processarPagamento();
            }
            if (escolha > 2) {
                System.out.println("Escolha Invalida!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de digitação!");
        } finally {
            sc.close();
            System.out.println("*** Sair ***");
        }
    }

    /*
     * Class Foma de Pagamento
     */
    public static class FormaDePagamento {

        public void processarPagamento() {
            System.out.println("Processando Pagamento.");
        }
    }

    /*
     * Class Cartao credito
     */
    public static class CartaoCredito extends entities.FormaDePagamento {
        @Override
        public void processarPagamento() {
            System.out.println("Pagamento por cartão de crédito.");
        }
    }

    /*
     * Class PayPal
     */
    public static class PayPal extends entities.FormaDePagamento {

        @Override
        public void processarPagamento() {
            System.out.println("Pagamento por PayPal.");
        }
    }
}

