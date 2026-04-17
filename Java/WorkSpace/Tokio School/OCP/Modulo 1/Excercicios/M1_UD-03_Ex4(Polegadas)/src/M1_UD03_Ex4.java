public class M1_UD03_Ex4 {
    public static void main(String[] args) {

        // Atributos
        double metros, polegadas;
        int contador = 1;

        /*
         * Para cada polegada até 144 polegadas, e salta uma linha e cada 12 polegadas.
         * e imprime na tela a conversão para metros
         */
        for (polegadas = 1; polegadas <= 144; polegadas++) {
            // contador para saltar uma linha e separar a cada 12 polegadas
            if (contador == 13) {
                System.out.println();
                contador = 1;
            }
            // para cada polegada converte em metros, Imprime e incrementa o contador(de linhas)
            metros = polegadas / 39.37;
            System.out.printf("%.0f polegadas são: %.3f metros\n", polegadas, metros);
            contador++;
        }
    }
}
