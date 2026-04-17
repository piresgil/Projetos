/**
 * @author Daniel Gil
 */
public class M1_UD04_Ex5 {
    /**
     * Method Main
     */
    public static void main(String[] args) {

        System.out.println("*** Bem Vindo ***");

        String str1 = "Radar";
        String str2 = "O galo ama o lago";
        String str3 = "Ana R";
        String str4 = "Daniel";

        System.out.println(str1 + ", " + esPalindriomo(str1)); // V
        System.out.println(str2 + ", " + esPalindriomo(str2)); // V
        System.out.println(str3 + ", " + esPalindriomo(str3)); // F
        System.out.println(str4 + ", " + esPalindriomo(str4)); // F
    }

    /**
     * Method "É Palindromo"
     * Verifica se uma palavra/texto é Palindromo,
     * Um palíndromo é uma palavra ou frase que se lê igual,
     * tanto quando se começa pelo princípio como pelo final.
     * Verifica nulidade do texto
     * Passa o texto para minúsculas com o "‘String’ Builder", demove caracteres não albabéticos,
     * Para finalizar a verificação, compara com o ".equals", o texto e o seu reverso, usando o method
     * "StringBuild" ".reverse()".
     *
     * @param texto a ser comparado/analisado como Palindromo
     * @return boolean
     */
    static boolean esPalindriomo(String texto) {
        //verifica nullidade
        if (texto == null) {
            return false;
        }

        // Converte o texto para minúsculas e remove todos os caracteres não alfabéticos
        StringBuilder stb = new StringBuilder();
        for (char letra : texto.toLowerCase().toCharArray()) {
            if (letra >= 'a' && letra <= 'z') {
                stb.append(letra);
            }
        }
        /*
         * Só uma nota, se calhar tenta refazer o exercício sem utilizar o String txtReverso = stb.reverse().toString();.
         * No fundo, *  o reverse() está a fazer mais um loop pela string inicial.
         * Um único loop seria suficiente para resolver o exercício, ao invés de dois.
         */

        int left = 0;
        int rigth = stb.length() - 1;

        while (left < rigth) {
            if (stb.charAt(left) != stb.charAt(rigth)) {
                return false;
            }
            left++;
            rigth--;
        }
        return true;

    /*
        // (.equals()) Compara o texto com o seu reverso, (.reverse())
        String txt = stb.toString();
        return txt.equals(stb.reverse().toString());
    */
    }
}