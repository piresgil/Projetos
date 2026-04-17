import java.util.*;
import java.util.stream.Collectors;

public class MainWithMap {
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        Map<Integer, Cidade> cidades = getIntegerCidadeMap();
        System.out.println(cidades);

        // Total cidade
        int totalCidades = cidades.size();
        System.out.println("Quantas cidades há no total: " + totalCidades);

        // Quantas cidades de “Portugal” têm mais de 1.000 habitantes? // Class nao refere País
        // com o method count
        int maisMilHabitantes = (int) cidades.values().stream()
                .filter(cidade -> cidade.getHabitantes() > 1000 && cidade.getPais().equals("Portugal"))
                .count(); // method contador
        System.out.println("Quantas cidades de “Portugal” têm mais de 1.000 habitantes: " + maisMilHabitantes);

        // De que distrito são as cidades // distrito ou provincia ?????
        // method collect para agrupar provincias
        Map<String, List<Cidade>> cidadesPorProvincia = cidades.values().stream()
                .collect(Collectors.groupingBy(Cidade::getProvincia)); // Agrupa cidades por provincias

        // passando as provincias agrupadas para um Set
        Set<String> provincias = cidadesPorProvincia.keySet();
        System.out.println("De que distrito são as cidades?: " + provincias);

        // De quantos distritos diferentes são as cidades
        int distritosIguais = (int) cidades.values().stream()
                .map(Cidade::getProvincia) // Extrai os nomes dos provincias
                .collect(Collectors.toSet()) // Coleta os distritos em um Set
                .size();
        System.out.println("De quantos distritos diferentes são as cidades?: " + distritosIguais);

        //Alguma cidade de Portugal tem mais de 50.000 habitantes
        // com method anyMatch para fazer a condição
        boolean maisCinquentaMil = (boolean) cidades.values().stream()
                .anyMatch(cidade -> cidade.getHabitantes() > 50000 && cidade.getPais().equals("Portugal")); // Condição com method anyMatch
        System.out.println("Alguma cidade de Portugal tem mais de 50.000 habitantes?: " + maisCinquentaMil);
    }

    /**
     * Method Auxiliar
     *
     * @return Map de Cidades
     */
    private static Map<Integer, Cidade> getIntegerCidadeMap() {
        Cidade c = new Cidade("Lisboa", "Portugal", "Centro", 1000000);
        Cidade c1 = new Cidade("Coimbra", "Portugal", "Centro", 100000);
        Cidade c3 = new Cidade("Castelo Branco", "Portugal", "Beira", 45000);
        Cidade c4 = new Cidade("Benquerença", "Portugal", "Interior", 500);
        Cidade c5 = new Cidade("Almada", "Portugal", "SUL", 70000);
        Cidade c2 = new Cidade("Porto", "Portugal", "Norte", 101000);
        Cidade c6 = new Cidade("Braga", "Portugal", "Norte", 3400);

        Cidade c7 = new Cidade("Brest", "França", "Bretanha", 1000000);
        Cidade c8 = new Cidade("Paris", "França", "Alpes", 100000);
        Cidade c9 = new Cidade("Bordeaux", "França", "Girond", 45000);
        Cidade c10 = new Cidade("Berlin", "Alemanha", "Baviera", 101000);
        Cidade c11 = new Cidade("Londres", "Inglaterra", "London", 70000);
        Cidade c12 = new Cidade("Madrid", "Espanha", "Extremadura", 3400);

        Map<Integer, Cidade> cidadesMap = new HashMap<>();
        cidadesMap.put(0, c);
        cidadesMap.put(1, c1);
        cidadesMap.put(2, c2);
        cidadesMap.put(3, c3);
        cidadesMap.put(4, c4);
        cidadesMap.put(5, c5);
        cidadesMap.put(6, c6);
        cidadesMap.put(7, c7);
        cidadesMap.put(8, c8);
        cidadesMap.put(9, c9);
        cidadesMap.put(10, c10);
        cidadesMap.put(11, c11);
        cidadesMap.put(12, c12);
        return cidadesMap;
    }
}