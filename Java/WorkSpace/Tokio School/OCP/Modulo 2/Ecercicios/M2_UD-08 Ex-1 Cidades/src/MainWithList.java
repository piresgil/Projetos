import java.util.*;
import java.util.stream.Collectors;

public class MainWithList {
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        List<Cidade> cidades = getListCidades();
        System.out.println(cidades);

        // Total cidade
        int totalCidades = cidades.size();
        System.out.println("Quantas cidades há no total: " + totalCidades);

        // Quantas cidades de “Portugal” têm mais de 1.000 habitantes? // Class nao refere País
        // com o method count
        int maisMilHabitantes = (int) cidades.stream()
                .filter(cidade -> cidade.getHabitantes() > 1000 && cidade.getPais().equals("Portugal"))
                .count();
        System.out.println("Quantas cidades de “Portugal” têm mais de 1.000 habitantes: " + maisMilHabitantes);

        // De que distrito são as cidades // distrito ou provincia ?????
        // method collect para agrupar provincias
        Map<String, List<Cidade>> cidadesPorProvincia = cidades.stream()
                .collect(Collectors.groupingBy(Cidade::getProvincia)); // Agrupa cidades por provincias
        // passando as provincias agrupadas para um Set
        Set<String> provincias = cidadesPorProvincia.keySet();
        System.out.println("De que distrito são as cidades?: " + provincias);

        // De quantos distritos diferentes são as cidades
        int distritosIguais = (int) cidades.stream()
                .map(Cidade::getProvincia) // Extrai os nomes dos provincias
                .collect(Collectors.toSet()) // Coleta os distritos em um Set
                .size();
        System.out.println("De quantos distritos diferentes são as cidades?: " + distritosIguais);

        //Alguma cidade de Portugal tem mais de 50.000 habitantes
        // com method anyMatch para fazer a condição
        boolean maisCinquentaMil = (boolean) cidades.stream()
                .anyMatch(cidade -> cidade.getHabitantes() > 50000 && cidade.getPais().equals("Portugal")); // Condição com method anyMatch
        System.out.println("Alguma cidade de Portugal tem mais de 50.000 habitantes?: " + maisCinquentaMil);
    }

    /**
     * Method Auxiliar
     *
     * @return Map de Cidades
     */
    private static List<Cidade> getListCidades() {
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

        List<Cidade> cidadesList = new ArrayList<>();
        cidadesList.add(c);
        cidadesList.add(c1);
        cidadesList.add(c2);
        cidadesList.add(c3);
        cidadesList.add(c4);
        cidadesList.add(c5);
        cidadesList.add(c6);
        cidadesList.add(c7);
        cidadesList.add(c8);
        cidadesList.add(c9);
        cidadesList.add(c10);
        cidadesList.add(c11);
        cidadesList.add(c12);
        return cidadesList;
    }
}