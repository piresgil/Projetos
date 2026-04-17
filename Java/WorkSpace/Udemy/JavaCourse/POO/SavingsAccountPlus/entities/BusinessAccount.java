/*
* @ Daniel Gil
*/

package entities;

public class BusinessAccount extends Account {

    private Double loanLimit;

    public BusinessAccount() {
        super();
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void load(Double amount) {

        if (amount >= loanLimit) {
            // acessa ao atributo protected da class (mãe)
            // menos os 10 de comissao bancaria
            balance += amount - 10.0;
        }
    }

    // sobrescrever metodo de retirada (withdraw)
    // regra de negocio na saving account cobra MAIS taxa
    // POR ISSO RETIRA DO BALAÇO
    @Override
    public void withdraw(Double amount) {
        super.withdraw(amount);
        balance -= 2.0;
    }
}