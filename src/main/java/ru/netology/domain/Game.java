package ru.netology.domain;

import repository.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotFoundException("Player with name " + playerName1 + "doesn't exist");
        }
        if (player2 == null) {
            throw new NotFoundException("Player with name " + playerName2 + "doesn't exist");
        }

        if (player1.getStrength()> player2.getStrength()){
            return 1;
        }
        if (player2.getStrength()> player1.getStrength()){
            return 2;
        }
        return 0;
    }
}
