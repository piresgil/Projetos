public class M2_Ex8 {

    public static void main(String[] args) {

        System.out.println("*** Bem-vindo ***");
        System.out.println("*** Contas ***");

        // Instancia das 2 contas, para comparação
        Conta acc1 = new Conta("João", 1, 2000.0);
        Conta acc2 = new Conta("Maria", 2, 500.00);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println();

        // Condicional para comparar a quantidade de dinheiro nas contas 1 e 2
        if (acc1.getQuantidade() > acc2.getQuantidade()) {
            System.out.println("*** Conta " + acc1.getNumeroConta() + " tem mais quantidade de dinheiro. ***");
        } else {
            System.out.println("*** Conta " + acc2.getNumeroConta() + " tem mais quantidade de dinheiro. ***");
        }
    }


    /*
     * Class Conta
     */
    public static class Conta {

        // Atributos da class
        private String titular;
        private int numeroConta;
        private double quantidade;

        // Construtor com argumentos
        public Conta(String titular, int numeroConta, double quantidade) {
            this.titular = titular;
            this.numeroConta = numeroConta;
            this.quantidade = quantidade;
        }

        // Getters e Setters
        public String getTitular() {
            return titular;
        }

        public void setTitular(String titular) {
            this.titular = titular;
        }

        public int getNumeroConta() {
            return numeroConta;
        }

        public void setNumeroConta(int numeroConta) {
            this.numeroConta = numeroConta;
        }

        public double getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(double quantidade) {
            this.quantidade = quantidade;
        }

        // Metodo toString, que mostra os atributos da class na consola
        @Override
        public String toString() {
            return "Numero de Conta: " + numeroConta +
                    ", Titular: " + titular +
                    ", Quantidade: " + quantidade;
        }
    }
}