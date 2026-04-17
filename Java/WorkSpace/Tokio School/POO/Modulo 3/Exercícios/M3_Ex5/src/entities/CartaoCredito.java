package entities;

public class CartaoCredito extends FormaDePagamento {
    @Override
    public void processarPagamento(){
        System.out.println("Pagamento por cartão de crédito.");
    }
}
