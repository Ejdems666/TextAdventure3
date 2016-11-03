package adv.character;

import adv.Room;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class ComputerPlayer extends Character implements ICharacterController {
    public ComputerPlayer(Room startingRoom) {
        currentRoom = startingRoom;
    }
}
