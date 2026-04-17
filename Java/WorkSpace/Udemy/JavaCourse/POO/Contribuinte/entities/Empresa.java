/*
 *  @ Daniel Gil
 */

package entities;

public class Empresa extends Contribuinte {
    private Integer nrFuncionarios;

    public Empresa() {

    }

    public Empresa(String name, Double renda, Integer nrFuncionarios) {
        super(name, renda);
        this.nrFuncionarios = nrFuncionarios;
    }

    public Integer getNrFuncionarios() {
        return nrFuncionarios;
    }

    public void setNrFuncionarios(Integer nrFuncionarios) {
        this.nrFuncionarios = nrFuncionarios;
    }

    @Override
    public Double tax() {
        Double tax = 0.0;
        if (nrFuncionarios > 10) {
            tax = this.getRenda() * 0.14;
            return tax;
        } else {
            tax = this.getRenda() * 0.16;
            return tax;
        }

    }
}