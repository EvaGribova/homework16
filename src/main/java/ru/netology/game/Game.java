package ru.netology.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегистрирован.");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName2 + " не зарегистрирован.");
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        return 0;
    }

}
