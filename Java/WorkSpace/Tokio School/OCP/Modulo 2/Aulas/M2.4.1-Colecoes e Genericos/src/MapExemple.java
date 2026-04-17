import classesAuxiliares.Pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExemple {

    public static void main(String[] args) {

        // Map dicionário
        // chave(indice) -> Valor
        // Map de -> para
        // Tem um indice apontado para um obj
        // não garante a ordem
        Map<Integer, Pessoa> mapPessoa = new HashMap<>();

        // Put adiciona na coleção
        mapPessoa.put(1, new Pessoa("Daniel", 37));
        mapPessoa.put(1, new Pessoa("Gil", 37)); // sobrescreve por cima do index 1, quer já existente
        mapPessoa.put(2, new Pessoa("Francisca", 3));
        mapPessoa.put(3, new Pessoa("Elisa", 4));
        System.out.println(mapPessoa);

        // Get muito rápido -> não necessita de percorrer a coleção
        Pessoa p = mapPessoa.get(2);
        System.out.println("Get: " + p);

        // KeySet
        Set<Integer> integers = mapPessoa.keySet(); // KeySet retorna todas as chaves
        System.out.println("keySet: " + integers);

        // Replace
        mapPessoa.replace(3, new Pessoa("Ana", 30)); // altera um registo da coleção chamando pela sua chave(indice)
        mapPessoa.replace(4, new Pessoa("Ana", 30)); // se chamar uma chave inexistente não dá qualquer exception

        // Put if Absent
        mapPessoa.putIfAbsent(4, new Pessoa("Daniel Gil", 38)); // adiciona na se não existir
        mapPessoa.putIfAbsent(1, new Pessoa("Joaquim", 68)); // adiciona na coleção se não existir, caso já exista não dá exception

        // Contain Key, se contem a chave
        System.out.println("contain key: " + mapPessoa.containsKey(4));
        System.out.println("contain key: " + mapPessoa.containsKey(1));

        // Contain Value, se contem o valor
        Pessoa maria = new Pessoa("Maria", 40); // precisa um obj para verificar se contem o valor
        mapPessoa.put(5, maria); // add um novo registo na coleção
        System.out.println("contain Value: " + mapPessoa.containsValue("Francisca")); // false, não verifica pela string
        System.out.println("contain Value: " + mapPessoa.containsValue(maria)); // true, contem o obj

        // mapPessoa.clear(); // Limpa toda a coleção

        System.out.println(mapPessoa);
    }
}
