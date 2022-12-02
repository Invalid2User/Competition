package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.Player;

class GameTest {
    Game game = new Game();

    @Test
    public void player1IsStronger() {
       // Game game = new Game();
        Player player1 = new Player(1, "Alex", 100);
        Player player2 = new Player(2, "Bobby", 50);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Alex", "Bobby");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void player2IsStronger(){
        Player player1 = new Player(1, "Alex", 10);
        Player player2 = new Player(2, "Bobby", 500);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Alex", "Bobby");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playersAreEqual(){
        Player player1 = new Player(1, "Alex", 10);
        Player player2 = new Player(2, "Bobby", 10);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Alex", "Bobby");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void player1IsNotRegistered(){
        Player player1 = new Player(1, "Alex", 10);
        Player player2 = new Player(2, "Bobby", 10);

        game.register(player2);

        Assertions.assertThrows(NotFoundException.class,
                () -> game.round("Alex","Bobby"));
    }

    @Test
    public void player2IsNotRegistered(){
        Player player1 = new Player(1, "Alex", 10);
        Player player2 = new Player(2, "Bobby", 10);

        game.register(player1);

        Assertions.assertThrows(NotFoundException.class,
                () -> game.round("Alex","Bobby"));
    }
}