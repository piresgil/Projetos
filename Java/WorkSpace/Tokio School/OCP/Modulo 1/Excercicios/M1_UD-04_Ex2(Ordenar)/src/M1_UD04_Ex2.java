/**
 * @author Daniel Gil
 */
/*
 * Bom trabalho!
 * Mais uma vez, antes de submeter o trabalho, convém validar que está tudo em ordem.
 * É normal pedir ajuda e ver outros recursos, mas convém ter cuidado na entrega./
 */
public class M1_UD04_Ex2 {

    /**
     * Method Main
     */
    public static void main(String[] args) {

        System.out.println("*** Bem Vindo ***");
        // araray de inteiros
        int[] numeros = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("*** Depois da ordenação em ordem decrescente ***");
        // Mostra array original
        for (int numero : numeros) {
            System.out.print(numero + " ");
        } // 0 1 2 3 4 5 6 7 8 9
        // Method Ordenar Numeros, ordenando por ordem decrescente
        System.out.println("\n*** Depois da ordenação em ordem decrescente ***");
        ordenarNumeros(numeros); // 9 8 7 6 5 4 3 2 1 0
    }

    /**
     * Method Ordenar Numeros
     * Analisa um array de inteiros, onde vai percorrer o array e encontrar o número maior,
     * para no final possa ordenar em ordem decrescente esse mesmo array, trocando o maior elemento
     * encontrado com o primeiro elemento do array original
     *
     * @param numeros array de números, que será percorrido, e ordenado em ordem decrescente
     */

    static void ordenarNumeros(int[] numeros) {
        int n = numeros.length;

        for (int i = 0; i < n - 1; i++) {
            // Encontrar o maior elemento no array original
            int maior = i;
            for (int j = i + 1; j < n; j++) {
                if (numeros[j] > numeros[maior]) {
                    maior = j;
                }
            }
            // Trocar o maior elemento encontrado com o primeiro elemento do array original
            int nrTemporaio = numeros[maior];
            numeros[maior] = numeros[i];
            numeros[i] = nrTemporaio;
        }
        // Imprimir
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

    }
}