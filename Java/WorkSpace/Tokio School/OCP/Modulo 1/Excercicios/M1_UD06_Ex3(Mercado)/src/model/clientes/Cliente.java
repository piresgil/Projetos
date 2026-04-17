package model.clientes;

import model.Entidade;

/**
 * Class Cliente
 */
public class Cliente extends Entidade {

    private int id;
    private int numeroCompras;

    public Cliente(String nome, String apelido, int numeroId, String morada, int telefone, int id, int numeroCompras) {
        super(nome, apelido, numeroId, morada, telefone);
        this.id = id;
        this.numeroCompras = numeroCompras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroCompras() {
        return numeroCompras;
    }

    public void setNumeroCompras(int numeroCompras) {
        this.numeroCompras = numeroCompras;
    }

    @Override
    public String toString() {

        return "Cliente: " + super.toString() +
                " {id: " + id +
                ", Compra nr: " + numeroCompras + "}";
    }

    /**
     * Method Compra,
     * representa uma compra pelo cliente, aqui para efeito de testes
     * recebe um valor q representa o valor de uma compra
     * e aatribui um desconto a cada 100 compras feitass
     */
    public double compra(double valor) {
        this.numeroCompras++;
        double desconto = valor;
        if (this.numeroCompras == 100) {
            this.numeroCompras = 0;
            return desconto * (1 - 0.01);
        }
        return valor;
    }
}
