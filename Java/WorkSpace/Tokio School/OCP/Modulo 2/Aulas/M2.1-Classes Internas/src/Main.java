public class Main {
    public static void main(String[] args) {

        // Animal a = new Animal(); // erro, construtor private
        Animal a = Animal.criarAnimal()
                .nome("Tobias")
                .especie(Especie.CAO)
                .idade(2)
                .dieta("Carnivoro")
                .build();

        System.out.println(Especie.PASSARO);
        System.out.println(Especie.PASSARO.getValor());

        String passaro = Especie.PASSARO.name();
        System.out.println(passaro);

        Especie gato = Especie.valueOf("GATO");
        System.out.println(gato);

        // Class Anónima
        Pessoa p = new Pessoa() {
            String nome;
            int idade;

            @Override
            public String getNome() {
                return nome;
            }
        };
        p.getNome();
    }
}

class Animal {
    final private String nome;
    final private Especie especie;
    final private int idade;
    final private String dieta;

    private Animal(Builder builder) {
        this.nome = builder.nome;
        this.especie = builder.especie;
        this.idade = builder.idade;
        this.dieta = builder.dieta;
    }

    public String getNome() {
        return nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public int getIdade() {
        return idade;
    }

    public String getDieta() {
        return dieta;
    }

    public static Builder criarAnimal() {
        return new Builder();
    }

    // Padrão Builder
    // Inner Class (Class interna) Builder, que vai construir um animal,
    // só faz sentido dentro da class Animal
    static class Builder {
        private String nome;
        private Especie especie;
        private int idade;
        private String dieta;

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder especie(Especie especie) {
            this.especie = especie;
            return this;
        }

        public Builder idade(int idade) {
            this.idade = idade;
            return this;
        }

        public Builder dieta(String dieta) {
            this.dieta = dieta;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }

    }
}