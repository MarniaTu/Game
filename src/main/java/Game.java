import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {

        players.put(player.getName(), player);
    }

    public Player findPlayerByName(String playerName) {
        for (String key : players.keySet()) {
            Player value = players.get(key);
            if (value.getName().equals(playerName)) {
                return value;
            }
        }
        return null;
    }

    public int findStrength(String playerName) {
        int strength;
        for (String key : players.keySet()) {
            Player value = players.get(key);
            if (value.getName().equals(playerName)) {
                return strength = value.getStrength();
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










