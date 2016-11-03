package adv.character;

import adv.Room;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class HumanPlayer extends Character implements ICharacterController {
    public HumanPlayer(Room startingRoom) {
        currentRoom = startingRoom;
    }
}
