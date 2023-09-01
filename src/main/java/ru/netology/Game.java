package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
   List<Player> players = new ArrayList<>();

   public Player register(Player player){
       players.add(player);
       return player;
   }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
    public int round(String playerName1, String playerName2){
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player2.getStrength() > player1.getStrength()) {
            return 2;
        } else return 0;

    }
}




