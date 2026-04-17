package model;

/**
 * Class Entidade,
 * representa uma pessoa\entidade,
 * Class abstrata, que vai ser herdada pelas suas entidades
 * como funcionarios e clientes
 * onde vai armazenar dados basicos como nome, morada, telf...etc
 */
public abstract class Entidade {

    private String nome;
    private String apelido;
    private int numeroId;
    private String morada;
    private int telefone;

    public Entidade(String nome, String apelido, int numeroId, String morada, int telefone) {
        this.nome = nome;
        this.apelido = apelido;
        this.numeroId = numeroId;
        this.morada = morada;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "{" +
                nome +
                " " + apelido +
                ", CC: " + numeroId +
                ", morada: " + morada +
                ", telf: " + telefone +
                '}';
    }
}
