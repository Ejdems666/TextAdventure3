package adv.cmd;

import adv.character.IFighter;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class FightInterpreter implements IInterpretor {
    private final IFighter monster;
    private final Character player;

    public FightInterpreter(IFighter monster, Character player) {
        this.monster = monster;
        this.player = player;
    }

    @Override
    public String interpret(String command) {
        return null;
    }
}
