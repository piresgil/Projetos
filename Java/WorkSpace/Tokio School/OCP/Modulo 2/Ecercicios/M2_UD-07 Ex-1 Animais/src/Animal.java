/**
 * @author Daniel Gil
 */

/**
 * Class Animal
 */
public class Animal {

    private String nome;
    private String descricao;
    private String raca;
    private Double peso;
    private Double altura;
    private boolean perigoso;
    private String comida;
    private int quantidadeComida;

    public Animal(String nome) {
        this.nome = nome;
    }

    public Animal(String nome, String descricao, String raca, Double peso, Double altura, boolean perigoso, String comida, int quantidadeComida) {
        this.nome = nome;
        this.descricao = descricao;
        this.raca = raca;
        this.peso = peso;
        this.altura = altura;
        this.perigoso = perigoso;
        this.comida = comida;
        this.quantidadeComida = quantidadeComida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public boolean isPerigoso() {
        return perigoso;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public int getQuantidadeComida() {
        return quantidadeComida;
    }

    @Override
    public String toString() {
        return "\n{" +
                "Nome= '" + nome + '\'' +
                ", Descrição= '" + descricao + '\'' +
                ", Raça= '" + raca + '\'' +
                ", Peso= " + peso +
                ", Altura= " + altura +
                ", Perigoso= " + perigoso +
                ", Comida= '" + comida + '\'' +
                ", Quantidade Comida= " + quantidadeComida +
                "}";
    }

    /**
     * Methods Pedidos
     */

    boolean marcarComoPerigoso() {
        return this.perigoso = true;
    }

    void alimentar(int quantidade) {
        this.quantidadeComida += quantidade;
    }
}