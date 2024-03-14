package ru.netology.game;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    Player player1 = new Player(1, "Masha", 19);
    Player player2 = new Player(4, "Kolya", 35);
    Player player3 = new Player(67, "Vanya", 35);

    @Test
    public void registerTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        List<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);
        expected.add(player3);
        List<Player> actual = game.getPlayers();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notRegisteredExceptionTest() {
        Game game = new Game();

        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round(player1.getName(), player2.getName()));
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round(player2.getName(), player1.getName()));
    }

    @Test
    public void firstPlayerWinTest() {
        Game game = new Game();

        game.register(player2);
        game.register(player1);

        int expected = 1;
        int actual = game.round(player2.getName(), player1.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWinTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round(player1.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nobodyWinTest() {
        Game game = new Game();

        game.register(player3);
        game.register(player2);

        int expected = 0;
        int actual = game.round(player2.getName(), player3.getName());

        Assertions.assertEquals(expected, actual);
    }
}
