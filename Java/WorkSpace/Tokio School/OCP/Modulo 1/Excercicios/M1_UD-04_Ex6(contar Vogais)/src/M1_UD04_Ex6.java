/**
 * @author Daniel Gil
 */
public class M1_UD04_Ex6 {

    /**
     * Method Main
     */
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        String str1 = "AeIoU";
        String str2 = "A abelha e feroz";
        String str3 = "A abelha é feroz?";
        System.out.print(str1);
        System.out.println(" ,Numero de Vogais: " + contarVogais(str1)); // 5
        System.out.print(str2);
        System.out.println(" ,Numero de Vogais: " + contarVogais(str2)); // 7
        System.out.print(str3);
        System.out.println(" ,Numero de Vogais: " + contarVogais(str3)); // 6

        System.out.println(contarVogais("123 4567 7890"));
    }

    /**
     * Method Contar Vogais
     * Analisa um texto, e conta as vogais
     *
     * @param texto local onde vão ser contadas as vogais, mediante uma condicional
     * @return numero vogais que estava no texto
     */
    static int contarVogais(String texto) {
        int contador = 0;
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                contador++;
            }
        }
        return contador;
    }
}