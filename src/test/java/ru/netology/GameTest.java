package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    List<Player> playerList = new ArrayList<>();
    Player player1 = new Player(1, "Николай", 100);
    Player player2 = new Player(5, "Пётр", 50);
    Player player3 = new Player(10, "Сергей", 100);

    @Test
    public void shouldFirstPlayerMustWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Николай", "Пётр");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSecondPlayerMustWins() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);

        int expected = 2;
        int actual = game.round("Пётр", "Сергей");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIfADraw() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Николай", "Сергей");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFirstPlayerNotRegistered() {
        Game game = new Game();
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Николай", "Пётр"));
    }

    @Test
    public void shouldTheSecondPlayerIsNotRegistered() {
        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Николай", "Пётр"));
    }

    @Test
    public void shouldNoneOfThePlayersAreRegistered() {
        Game game = new Game();
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Николай", "Пётр"));
    }
}
