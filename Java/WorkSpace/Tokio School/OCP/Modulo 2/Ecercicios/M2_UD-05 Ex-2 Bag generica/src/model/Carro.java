package model;

/**
 * @author Daniel Gil
 */

/**
 * Class carro,
 * class auxiliar, para testes da coleção
 */
public class Carro {
    private String name;

    public Carro(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + "name: " + name + "}";
    }
}