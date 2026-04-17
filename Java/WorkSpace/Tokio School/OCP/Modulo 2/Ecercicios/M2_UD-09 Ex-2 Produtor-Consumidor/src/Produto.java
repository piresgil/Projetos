public class Produto {
    String Nome;

    public Produto(String nome) {
        Nome = nome;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: '" + Nome + '\'';
    }
}
