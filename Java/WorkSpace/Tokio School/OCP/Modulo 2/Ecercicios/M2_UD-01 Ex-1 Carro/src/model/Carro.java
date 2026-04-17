package model;

/**
 * Class Carro
 */
public class Carro {
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia;
    private int velocidadeMaxima;

    private Chassis chassis;
    private Roda[] rodas = new Roda[4];

    public Carro(String matricula, String marca, String modelo, int potencia, int velocidade,
                 Chassis chassi, Roda roda1, Roda roda2, Roda roda3, Roda roda4) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.velocidadeMaxima = velocidade;

        chassis = chassi;
        rodas[0] = roda1;
        rodas[1] = roda2;
        rodas[2] = roda3;
        rodas[3] = roda4;
    }

    Chassis getChassi() {
        return chassis;
    }

    public void setChassi(Chassis chassi) {
        this.chassis = chassi;
    }

    public Roda[] getRodas() {
        return rodas;
    }

    public void setRodas(Roda[] rodas) {
        this.rodas = rodas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getVelocidade() {
        return velocidadeMaxima;
    }

    public void setVelocidade(int velocidade) {
        this.velocidadeMaxima = velocidade;
    }

    @Override
    public String toString() {
        return "Carro:\n" +
                "{Matricula: " + matricula +
                ", Marca: " + marca +
                ", Modelo: " + modelo +
                ", Potencia: " + potencia +
                ", Velocidade Maxima: " + velocidadeMaxima + "}" +
                ", \n{Chassi: " + chassis + "}" +
                ", \n{Roda Frente Esq: " + rodas[0] + "}" +
                ", \n{Roda Frente Drt: " + rodas[1] + "}" +
                ", \n{Roda Traseira Esq: " + rodas[2] + "}" +
                ", \n{Roda Traseira Drt: " + rodas[3] + "}";
    }

    /**
     * Class Chassi, Class interna de Carro
     */
    public static class Chassis {

        private String material;
        private double peso;

        public Chassis(String material, double peso) {
            this.material = material;
            this.peso = peso;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public double getPeso() {
            return peso;
        }

        public void setPeso(double peso) {
            this.peso = peso;
        }

        @Override
        public String toString() {
            return "Material: " + material +
                    ", Peso: " + peso;
        }
    }

    /**
     * Class Roda, Class interna de Carro
     */
    public static class Roda {

        // Enum interno para o tipo de roda
        public enum TipoRoda {
            SECO, CHUVA
        }

        private String medida;
        private TipoRoda tipo;
        private String marca;

        private String modelo;

        public Roda(String medida, TipoRoda tipo, String marca, String modelo) {
            this.medida = medida;
            this.tipo = tipo;
            this.marca = marca;
            this.modelo = modelo;
        }

        public String getMedida() {
            return medida;
        }

        public void setMedida(String medida) {
            this.medida = medida;
        }

        public TipoRoda getTipo() {
            return tipo;
        }

        public void setTipo(TipoRoda tipo) {
            this.tipo = tipo;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        @Override
        public String toString() {
            return "Medida: " + medida +
                    ", Tipo: " + tipo +
                    ", Marca: " + marca +
                    ", Modelo: " + modelo;
        }
    }
}