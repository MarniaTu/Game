import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<>();

    public void register(Player player) {

        players.add(player);
    }

    public Player findPlayerByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public int findStrength(String playerName) {
        int strength;
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return strength = player.getStrength();
            }
        }
        return -1;
    }

    public int round(String playerName1, String playerName2) {

        if (findPlayerByName(playerName1) == null) {
            throw new NotRegisteredException("The player with playerName " + playerName1 + " is not registered");
        } else if (findPlayerByName(playerName2) == null) {
            throw new NotRegisteredException("The player with playerName " + playerName2 + " is not registered");
        }

        if (findStrength(playerName1) > findStrength(playerName2)) {
            return 1;
        } else if (findStrength(playerName1) < findStrength(playerName2)) {
            return 2;
        } else {
            return 0;
        }

    }
}










