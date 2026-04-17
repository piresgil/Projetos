package main.application.utils;


import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.MouseEvent;
import main.application.model.Personagem;

public class ValidationUtils {

    /**
     * Método de validação do personagem
     */
    public static boolean validarPersonagem(Personagem personagem) {
        // Verifica se o personagem não é nulo antes de realizar a validação
        if (personagem != null) {
            return personagem.getTipo() != null          // Tipo não pode ser nulo
                    && personagem.getNome() != null      // Nome não pode ser nulo
                    && !personagem.getNome().trim().isEmpty() // Nome não pode ser vazio
                    && personagem.getVida() > 0          // Vida deve ser maior que 0
                    && personagem.getArmadura() >= 0     // Armadura não pode ser negativa
                    && personagem.getAtaque() >= 0;      // Ataque não pode ser negativo
        }
        return false;  // Retorna false se o personagem for nulo*/
    }

    /**
     * Verifica se o clique ocorreu em um nó protegido ou em seus filhos
     */
    public static boolean isClickInsideAllowedNodes(Parent parent, MouseEvent event) {
        Node target = (Node) event.getTarget();
        return isAllowedNode(target);
    }

    /**
     * Verifica se o nó ou qualquer de seus pais é um nó protegido
     */
    private static boolean isAllowedNode(Node node) {
        while (node != null) {
            if (isProtectedNodeType(node)) {
                return true;
            }
            node = node.getParent();
        }
        return false;
    }

    /**
     * Verifica tipos específicos de nós que devem proteger o clique
     */
    private static boolean isProtectedNodeType(Node node) {
        return node instanceof ListView ||
                //   node instanceof Button ||
                //   node instanceof TextField ||
                node instanceof TextInputControl ||
                node instanceof ComboBox ||
                node instanceof Labeled; // Adicionado para capturar labels dentro de botões
    }

    /**
     * Método alternativo se precisar verificar por coordenadas
     */
    public static boolean isClickInProtectedArea(Parent parent, MouseEvent event) {
        // Converte as coordenadas uma única vez
        Point2D sceneCoords = new Point2D(event.getSceneX(), event.getSceneY());

        // Verifica todos os filhos protegidos
        for (Node child : parent.getChildrenUnmodifiable()) {
            if (isProtectedNodeType(child)) {
                Bounds bounds = child.localToScene(child.getBoundsInLocal());
                if (bounds.contains(sceneCoords)) {
                    return true;
                }
            }
            // Verificação recursiva para containers
            if (child instanceof Parent) {
                if (isClickInProtectedArea((Parent) child, event)) {
                    return true;
                }
            }
        }
        return false;
    }
}
