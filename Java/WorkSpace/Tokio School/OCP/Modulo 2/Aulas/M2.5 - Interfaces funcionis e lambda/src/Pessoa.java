import interfaces.Printable;

public class Pessoa implements Printable {

    private Integer idade;
    private String nome;

    @Override
    public String print(String nome, String ultimoNome) {
        return nome + ultimoNome;
    }

    // @Override
    // public void print() {
    //     System.out.println("Imprimindo Pessoa");
    // }
}
