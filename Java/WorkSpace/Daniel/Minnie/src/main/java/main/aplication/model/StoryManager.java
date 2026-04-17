package main.aplication.model;

import java.util.HashMap;
import java.util.Map;

public class StoryManager {
    private Map<String, Cena> cenas = new HashMap<>();
    private String cenaAtualId = "inicio";

    public StoryManager() {
        carregarCenas();
    }

    private void carregarCenas() {
        cenas.put("inicio", new Cena(
                "A Minnie entra no jardim mágico. Há dois caminhos...",
                "/img/Minnie-sheetTransparente.png",  // Caminho para a spritesheet
                "Seguir pelas flores cor-de-rosa",
                "flores",
                "Seguir pelas borboletas",
                "borboletas"

        ));  cenas.put("flores", new Cena(
                "Ela encontra uma fada encantada entre as flores!",
                "/img/Minnie-sheetTransparente.png",  // Caminho para a spritesheet
                "Falar com a fada",
                "fada",
                "Continuar sozinha",
                "fim1"
        ));

        cenas.put("borboletas", new Cena(
                "As borboletas levam a Minnie até uma árvore mágica.",
                "/img/Minnie-sheetTransparente.png",  // Caminho para a spritesheet
                "Subir na árvore",
                "fim2",
                "Dar meia-volta",
                "fim1"
        ));

        cenas.put("fada", new Cena(
                "A fada oferece à Minnie um presente mágico!",
                "/img/Minnie-sheetTransparente.png",  // Caminho para a spritesheet
                "Agradecer",
                "fim2",
                "Recusar",
                "fim1"
        ));

        cenas.put("fim1", new Cena(
                "A aventura termina, mas a Minnie promete voltar!",
                "/img/Minnie-sheetTransparente.png",  // Caminho para a spritesheet
                "Recomeçar",
                "inicio",
                "Sair",
                "fim1"
        ));

        cenas.put("fim2", new Cena(
                "A Minnie encontra o castelo brilhante no fim da viagem!",
                "/img/Minnie-sheetTransparente.png",  // Caminho para a spritesheet
                "Recomeçar",
                "inicio",
                "Sair",
                "fim2"
        ));
    }

    public Cena getCenaAtual() {
        return cenas.get(cenaAtualId);
    }

    public void avancarParaCena(String id) {
        if (cenas.containsKey(id)) {
            cenaAtualId = id;
        }
    }
}
