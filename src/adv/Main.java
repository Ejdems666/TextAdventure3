package adv;

import adv.character.Character;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class Main {

    public static void main(String[] args) {
        Initiator initiator = new Initiator();
        Room startingRoom = initiator.createMap();
        Character player = initiator.createPlayer(startingRoom);
        Game game = new Game(player);
        game.run();
    }
}
