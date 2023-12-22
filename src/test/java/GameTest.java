import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    Game game = new Game();
    Player player1 = new Player(100, "Anna", 300);
    Player player2 = new Player(200, "Nik", 450);
    Player player3 = new Player(240, "Henry", 470);
    Player player4 = new Player(300, "Sam", 520);
    Player player5 = new Player(325, "Alice", 450);

    @Test
    public void shouldRegisterPlayers() {

        List<Player> players = new ArrayList<>();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

    }

    @Test
    public void shouldFindPlayerByName() {

        List<Player> players = new ArrayList<>();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        game.findPlayerByName("Henry");

        Player expected = player3;
        Player actual = game.findPlayerByName("Henry");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotFindPlayerByName() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        game.findPlayerByName("Simona");

        Player expected = null;
        Player actual = game.findPlayerByName("Simona");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindStrength() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        game.findStrength(player4.getName());

        int expected = player4.getStrength();
        int actual = game.findStrength(player4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindStrength() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        game.findStrength("John");

        int expected = -1;
        int actual = game.findStrength("John");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionForFirstPlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Emily", player4.getName());
        });
    }

    @Test
    public void shouldThrowExceptionForSecondPlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), "Emily");
        });
    }

    @Test
    public void shouldWinFirstPlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        game.round(player3.getName(), player2.getName());

        int expected = 1;
        int actual = game.round(player3.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        game.round(player3.getName(), player4.getName());

        int expected = 2;
        int actual = game.round(player3.getName(), player4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindNoWinners() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        game.round(player2.getName(), player5.getName());

        int expected = 0;
        int actual = game.round(player2.getName(), player5.getName());

        Assertions.assertEquals(expected, actual);
    }
}

