package application;/*
 * @ Daniel Gil
 */

public class Escopo_Inicializacao {
    /*
    * 
    */
    public static void main(String[] args) {

        /*
         * • Escopo de uma variável: é a região do programa onde a variável é
         * válida, ou seja, onde ela pode ser referenciada.
         * • Uma variável não pode ser usada se não for iniciada
         */

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        /*
         * double price = 400.00;
         * double discount;
         * if (price < 200){
         * discount = price * 0.1;
         * }
         * System.out.println(discount);"); ///// ERRO ESSA VAR (discount) ESTA
         * DECLARADA DENTRO DO IF (escopo do if)
         */

        double price = 400.00;
        double discount = 0.00; // assim a variavel já e declarada cm valor inicial
        System.out.println("Exemplo de var iniciada com (0)");
        System.out.println("var dentro do escopo do IF Nao aparecerá, porque condição assim o determina");
        if (price < 200) {
            discount = price * 0.1;
            System.out.println("var dentro do escopo do IF");
            System.out.println(discount);
        }
        System.out.println("fora do escopo if");
        System.out.println(discount);// sem valor inicial neste caso (0)
        System.out.println();
        double price2 = 400.00;
        double discount2; // variavel sem valor inicial
        System.out.println("Exemplo de var iniciada SEM QUALQUER VALOR");
        if (price < 200) {
            discount2 = price2 * 0.1;
        } else {
            System.out.println("var dentro do escopo do IF cm o Else");
            discount2 = 1; // dando um valor para var dentro do escopo if else
            System.out.println(discount2);
        }
        System.out.println("mesma var fora do escopo if");
        System.out.println(discount2);

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}