package adv;

import adv.character.Character;
import adv.cmd.MovementInterpreter;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class Game {
    private final MovementInterpreter movementInterpreter;
    private final Character player;

    public Game(Character player) {
        movementInterpreter = new MovementInterpreter();
        this.player = player;
    }

    public void run() {

    }
}
