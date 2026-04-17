package main.application.service;

import main.application.model.Besta;
import main.application.model.Heroi;
import main.application.model.Personagem;
import main.application.repository.PersonagemJsonRepository;

import java.util.*;

public class PersonagemManager {
    private List<Heroi> listaHerois;
    private List<Besta> listaBestas;
    private final Map<String, Personagem> cache;

    public PersonagemManager() {
        this.listaHerois = PersonagemJsonRepository.carregarHerois();
        this.listaBestas = PersonagemJsonRepository.carregarBestas();
        this.cache = new HashMap<>(); // Cache para todos os personagens? Ou caches separados?
        inicializarCache();
    }

    private void inicializarCache() {
        listaHerois.forEach(heroi -> cache.put(heroi.getId(), heroi));
        listaBestas.forEach(besta -> cache.put(besta.getId(), besta)); // Se você tiver um cache unificado
    }

    /**
     * Busca um personagem pelo ID no cache.
     *
     * @param id O ID do personagem.
     * @return O personagem encontrado ou Optional vazio se não encontrado.
     */
    public Optional<Personagem> findById(String id) {
        return Optional.ofNullable(cache.get(id));
    }

    // Busca todos os Herois
    public List<Personagem> findAllHerois() {
        return new ArrayList<>(listaHerois);
    }

    public void salvarHerois(List<Heroi> listaPersonagens) {
        this.listaHerois = listaPersonagens;
        PersonagemJsonRepository.salvarHerois(listaPersonagens);  // Salva em herois.json
    }

    public List<Personagem> findAllBestas() {
        return new ArrayList<>(listaBestas);
    }

    public void salvarBestas(List<Besta> listaPersonagens) {
        this.listaBestas = listaPersonagens;
        PersonagemJsonRepository.salvarBestas(listaPersonagens); // Salva em bestas.json
    }

    public void adicionarHeroi(Heroi heroi) {
        listaHerois.add(heroi);
        cache.put(heroi.getId(), heroi);
    }

    public void adicionarBesta(Besta besta) {
        listaBestas.add(besta);
        cache.put(besta.getId(), besta);
    }

    public void atualizarHeroi(Heroi heroi) {
        for (int i = 0; i < listaHerois.size(); i++) {
            if (listaHerois.get(i).getId().equals(heroi.getId())) {
                listaHerois.set(i, heroi);
                cache.put(heroi.getId(), heroi);
                return;
            }
        }
    }

    public void removerHeroi(String id) {
        listaHerois.removeIf(heroi -> heroi.getId().equals(id));
        cache.remove(id);
    }

    public void atualizarBesta(Besta besta) {
        for (int i = 0; i < listaBestas.size(); i++) {
            if (listaBestas.get(i).getId().equals(besta.getId())) {
                listaBestas.set(i, besta);
                cache.put(besta.getId(), besta);
                return;
            }
        }
    }

    public void removerBesta(String id) {
        listaBestas.removeIf(besta -> besta.getId().equals(id));
        cache.remove(id);
    }

    public void salvarTodos() {
        PersonagemJsonRepository.salvarHerois(listaHerois);
        PersonagemJsonRepository.salvarBestas(listaBestas);
    }
}
