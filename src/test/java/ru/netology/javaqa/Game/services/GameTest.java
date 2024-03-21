package ru.netology.javaqa.Game.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenSecondPlayerWin() {
        Player kolya = new Player(123, "Коля", 220);
        Player roma = new Player(130, "Рома", 200);
        Game game = new Game();

        game.register(kolya);
        game.register(roma);
        int actual = game.round("Рома", "Коля");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Player roma = new Player(1, "Рома", 220);
        Player kolya = new Player(2, "Коля", 200);
        Game game = new Game();

        game.register(roma);
        game.register(kolya);
        int actual = game.round("Рома", "Коля");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenStrengthsEqual() {
        Player kolya = new Player(1, "Коля", 100);
        Player roma = new Player(2, "Рома", 100);
        Game game = new Game();

        game.register(kolya);
        game.register(roma);
        int actual = game.round("Рома", "Коля");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player kolya = new Player(1, "Коля", 100);
        Game game = new Game();

        game.register(kolya);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Юра", "Коля"));
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player kolya = new Player(1, "Коля", 100);
        Game game = new Game();

        game.register(kolya);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Коля", "Юра"));
    }

}

