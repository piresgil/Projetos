package entities;

public class PayPal extends FormaDePagamento{

    @Override
    public void processarPagamento() {
        System.out.println("Pagamento por PayPal.");
    }
}
