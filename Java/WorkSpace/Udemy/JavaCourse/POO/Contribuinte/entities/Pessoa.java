/*
 *  @ Daniel Gil
 */

package entities;

public class Pessoa extends Contribuinte {

    private Double gastoSaude;

    public Pessoa() {
        super();
    }

    public Pessoa(String name, Double renda, Double gastoSaude) {
        super(name, renda);
        this.gastoSaude = gastoSaude;
    }

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    // fica: (50000 * 25%) - (2000 * 50%) = 11500.0

    @Override
    public Double tax() {
        Double tax = 0.0;
        if (gastoSaude > 0) {
            tax = (this.getRenda() * 0.25) - (gastoSaude * 0.50);
            return tax;
        } else {
            tax = this.getRenda() * 0.25;
            return tax;
        }
    }
}