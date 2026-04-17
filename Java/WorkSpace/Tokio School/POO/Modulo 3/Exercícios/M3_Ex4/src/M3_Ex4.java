import java.util.InputMismatchException;
import java.util.Scanner;

public class M3_Ex4 {

    public static void main(String[] args) {

        System.out.println("*** Bem-vindo ***");
        System.out.println("*** Veículos ***");

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Escolha um Veículo:");
            System.out.println("1.Carro");
            System.out.println("2.Moto");
            int escolha = sc.nextInt();

            if (escolha == 1) {
                System.out.print("Marca: ");
                String marca = sc.next();
                System.out.print("Ano: ");
                int ano = sc.nextInt();
                System.out.print("Nr Portas: ");
                int nrPortas = sc.nextInt();

                Carro carro = new Carro(marca,ano,nrPortas);
                carro.apresentar();
            }
            if (escolha == 2) {
                System.out.print("Marca: ");
                String marca = sc.next();
                System.out.print("Ano: ");
                int ano = sc.nextInt();
                System.out.print("Tipo de Moto: ");
                String tipoMoto = sc.next();

                Moto moto = new Moto(marca,ano,tipoMoto);
                moto.apresentar();
            }
            if (escolha > 2) {
                System.out.println("Escolha Invalida!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de digitação!");
        } finally {
            sc.close();
            System.out.println("*** Sair ***");
        }
    }

    /*
     * Class Veiculo
     */
    public static class Veiculo {
        protected String marca;
        protected int ano;

        public Veiculo(String marca, int ano) {
            this.marca = marca;
            this.ano = ano;
        }
        public String getMarca() {
            return marca;
        }
        public void setMarca(String marca) {
            this.marca = marca;
        }
        public int getAno() {
            return ano;
        }
        public void setAno(int ano) {
            this.ano = ano;
        }
        public void apresentar() {
            System.out.println("Marca: " + marca + ", Ano: " + ano);
        }
    }

    /*
     * Class Carro
     */
    public static class Carro extends Veiculo {
        protected int numeroPortas;

        public Carro(String marca, int ano, int numeroPortas) {
            super(marca, ano);
            this.numeroPortas = numeroPortas;
        }
        public int getNumeroPortas() {
            return numeroPortas;
        }

        public void setNumeroPortas(int numeroPortas) {
            this.numeroPortas = numeroPortas;
        }

        @Override
        public void apresentar() {
            System.out.println("\nMarca: " + marca + ", Ano: " + ano + ", Nr de portas: " + numeroPortas);
        }
    }

    /*
     * Class Moto
     */
    public static class Moto extends Veiculo {
        protected String tipoMoto;

        public Moto(String marca, int ano, String tipoMoto) {
            super(marca, ano);
            this.tipoMoto = tipoMoto;
        }
        public String getTipoMoto() {
            return tipoMoto;
        }

        public void setTipoMoto(int numeroPortas) {
            this.tipoMoto = tipoMoto;
        }

        @Override
        public void apresentar() {
            System.out.println("\nMarca: " + marca + ", Ano: " + ano + ", Tipo de Moto: " + tipoMoto);
        }
    }
}