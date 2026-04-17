package com.game.object.util;

import com.game.object.GameObject;
import com.game.object.Player;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Handler {
    // variables
    private List<GameObject> gameObjects;
    private Player player;

    // constructor
    public Handler() {
        gameObjects = new LinkedList<>();
    }

    public void tick() {
        for (GameObject obj : gameObjects) {
            obj.trick();
        }
    }

    public void render(Graphics g) {
        for (GameObject obj : gameObjects) {
            obj.render(g);
        }
    }

    public void addObj(GameObject obj) {
        System.out.println("add:");
        gameObjects.add(obj);
    }

    public void removeObj(GameObject obj) {
        gameObjects.remove(obj);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    /*
     * Explicação: Esta verificação inicial assegura que a instância de Player associada a este sistema (this.player)
     * ainda não foi definida. Se this.player já contiver uma referência a um objeto Player, a função retorna -1.
     * Este valor de retorno é tipicamente usado para indicar uma falha ou um erro na operação (neste caso, a tentativa de definir um jogador quando um já existe).
     */
    public int setPlayer(Player player) {
        if (this.player != null) {
            return -1; // Propósito: Garantir que apenas um jogador seja definido.
        }

        addObj(player); // Propósito: Adicionar o jogador a uma coleção de objetos gerenciados pelo sistema.
        this.player = player;
        return 0;
    }

    // same logic setPlayer()
    public int removePlayer() {
        if (player == null) {
            return -1;
        }

        removeObj(player);
        this.player = null;
        return 0;
    }

    public Player getPlayer() {
        return player;
    }
}
