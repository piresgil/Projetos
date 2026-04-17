/*
* @ Daniel Gil
*/

package entities;

public /*final*/ class SavingAccount extends Account {

    private Double interestRate;

    public SavingAccount() {
        super();
    }

    public SavingAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        // formula para calcular e dar update no
        // balance pela taxa de juro (conta poupança(savings account))
        // regra de negocio
        balance += balance * interestRate;
    }

    // sobrescrever metodo de retirada (withdraw)
    // regra de negocio na saving account nao cobra taxa
    @Override
    public /*final*/ void withdraw(Double amount) {
        balance -= amount;
    }
}