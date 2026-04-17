/**
 * @author Daniel Gil
 */
public class M1_UD04_Ex4 {
    /**
     * Method Main
     * <p>
     * Um polímero é uma macromolécula formada pela união de uma ou mais unidades
     * simples chamadas monómeros.
     * Se a letra está em maiúsculas, representa um monómero com polaridade positiva,
     * se está em minúsculas, representa polaridade negativa.
     * <p>
     * Quando num polímero coincidem duas unidades com polaridades distintas, ambas as
     * unidades reagem destruindo-se e deixando o polímero sem as mesmas.
     */
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        String str1 = "CaAdbb";
        String str2 = "rFvdAaDVb";

        System.out.println("Polimero 1 original: " + str1); // CaAdbb
        System.out.println("Polimero 1 reduzido: " + reduzirPolimero(str1)); // Cdbb
        System.out.println("Polimero 2 original: " + str2); // rFvdAaDVb
        System.out.println("Polimero 2 reduzido: " + reduzirPolimero(str2)); // rFb
    }

    /**
     * Method Reação
     * Função auxiliar para verificar se dois monómeros reagem uma com a outra.
     * <p>
     * Quando num polímero coincidem duas unidades com polaridades distintas, ambas as
     * unidades reagem destruindo-se e deixando o polímero sem as mesmas.
     * <p>
     * Por exemplo,
     * no polímero “CaAdbb”, o par “aA” reage eliminando-se automaticamente e deixando o polímero como “Cdbb”.
     * “C” e “d” são de polaridades distintas, mas ao serem monómeros distintos não reagem entre si.
     * As unidades “bb” são do mesmo tipo, mas ao ter a mesma polaridade não reagem entre si.
     * A eliminação de unidades ou monómeros pode produzir eliminações em cascata
     *
     * @param monomero1 primeiro monómero para comparação
     * @param monomero2 segundo monómero para comparação
     * @return uma reação que pode ser positiva, ou falsa se não houver reação entre os monómeros,
     * Usa method ". ToLowerCase()" para converter para minúsculas e fazer a comparação
     * a reação acontece quando, os dois monómeros forem iguais
     * (em minúsculas, mas diferentes no seu estado original)
     */
    private static boolean reacao(char monomero1, char monomero2) {
        return Character.toLowerCase(monomero1) == Character.toLowerCase(monomero2)
                && monomero1 != monomero2;
    }

    /**
     * Method Reduzir Polímero
     * Verifica se existe reação entre monómeros e retorna um novo polímero, depois das reações
     * Utiliza o "‘String’ Builder" para fazer as reações, ler a ‘string’ polímero
     * e a reorganizar a ‘string’ adicionando os novos monómeros para a comparação da reação.
     * <p>
     * Por exemplo, o polímero “rFvdAaDVb” ao reagir elimina sucessivamente o par “Aa”, o “dD”
     * e o “vV” para deixar um resultado de “rFb”. Uma reação em cadeia pode eliminar
     * por completo o polímero.
     *
     * @param polimero, conjunto de monómeros(char) que formam um Polimero(‘String’)
     * @return novo Polímero, com as alterações conforme as reações encontradas.
     */
    public static String reduzirPolimero(String polimero) {
        StringBuilder newPolimero = new StringBuilder();

        for (char monomero : polimero.toCharArray()) {
            int tamanho = newPolimero.length();

            // Verifica se há um caractere anterior que pode reagir com a unidade/monomero atual
            if (tamanho > 0 && reacao(newPolimero.charAt(tamanho - 1), monomero)) {

                // Remove o último caratere, se houver reação
                newPolimero.deleteCharAt(tamanho - 1);
            } else {

                // Adiciona a unidade/monómero ao StringBuilder
                newPolimero.append(monomero);
            }
        }
        return newPolimero.toString();
    }
}