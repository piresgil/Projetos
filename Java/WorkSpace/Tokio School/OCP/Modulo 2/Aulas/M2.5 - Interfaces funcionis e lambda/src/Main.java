import interfaces.Printable;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Interfaces funcionais, Expressões Lambda ***");

        // Interfaces Funcionais -> só possuem um método e somente um método abstracto
        // por padrão usa @FunctionalInterface
        Pessoa joao = new Pessoa();
        // joao.print();
        // imprimirPessoas(joao);

        // Expressão Lambda -> implementa as Interface funcional
        // Exemplo sem parâmetros
        // imprimirPessoas(
        //         () -> {
        //             System.out.println("Imprimindo Pessoa, Lambda");
        //         }
        // );

        // Exemplo com parâmetros
        // imprimirPessoas(
        //         (n) -> {
        //              System.out.println("Imprimindo Pessoa, Lambda: " + n);
        //         }
        // );

        // Exemplo com 2 parâmetros
        // Printable printable = (nome, ultimoNome) -> {
        //     System.out.println("exemplo");
        //     System.out.println("nome completo: " + nome + " " + ultimoNome);
        // };
        // imprimirPessoas(printable);

        // Exemplo retornando String com 2 parâmetros
        // Printable printable = (nome, ultimoNome) -> {
        //     System.out.println("exemplo");
        //     System.out.println("nome completo: " + nome + " " + ultimoNome);
        //     String nomeCompleto = nome + " " + ultimoNome;
        //     return nomeCompleto;
        // };
        // imprimirPessoas(printable);

        // SIMPLIFICANDO numa só linha - Exemplo retornando String com 2 parâmetros
        Printable printable = (nome, ultimoNome) -> nome + " " + ultimoNome;
        imprimirPessoas(printable);
    }

    // Metodo que implementa Interface funcional
    static void imprimirPessoas(Printable printable) {
        String nome = printable.print("João", "chagas");
        System.out.println(nome);;
    }
}