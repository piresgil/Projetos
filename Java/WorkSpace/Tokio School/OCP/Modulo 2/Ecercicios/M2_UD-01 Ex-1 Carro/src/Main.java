import model.Carro;

/**
 * @author Daniel Gil
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem vindo ***");

        // Criando Chassis
        Carro.Chassis chassi = new Carro.Chassis("Aço", 1200);
        Carro.Chassis chassi2 = new Carro.Chassis("Aluminio", 1000);

        // Criando Rodas
        Carro.Roda roda = new Carro.Roda("195/65 R15", Carro.Roda.TipoRoda.SECO, "Michelin", "Primacy 4");
        Carro.Roda roda2 = new Carro.Roda("195/65 R15", Carro.Roda.TipoRoda.CHUVA, "Pirelli", "AllSeason SF3");

        // Criando Carros
        Carro carro = new Carro("AAA-AAA-AAA", "AAA", "AAA", 500, 200,
                chassi, roda, roda, roda2, roda2);
        Carro carro2 = new Carro("BBB-BBB-BBB", "BBB", "BBB", 1000, 220,
                chassi2, roda2, roda2, roda, roda);

        System.out.println(carro);
        System.out.println();
        System.out.println(carro2);
    }
}