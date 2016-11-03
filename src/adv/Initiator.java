package adv;

import adv.character.Character;
import adv.character.ComputerPlayer;
import adv.character.HumanPlayer;
import adv.map.MapGenerator;
import libs.FileIO;
import libs.form.Form;

/**
 * Created by Ejdems on 03/11/2016.
 */
public class Initiator {
    public Character createPlayer(Room startingRoom) {
        Form form = createPlayerForm();
        form.askForAllFields();
        Character character;
        if (form.get("type").equals("c")) {
            character = new ComputerPlayer(startingRoom);
        } else {
            character = new HumanPlayer(startingRoom);
        }
        return character;
    }

    private Form createPlayerForm() {
        Form form = new Form();
        form.addText("type", "Computer or Player? c/p").setAllowedValues(new String[]{"c", "p"});
        form.addText("name", "Insert your name");
        return form;
    }

    public Room createMap() {
        Form form = createMapForm();
        form.askForAllFields();
        MapGenerator map = new MapGenerator(form.get("name")+".txt");
        return map.createDungeonMap();
    }

    private Form createMapForm() {
        Form form = new Form();
        form.addText("name", "Insert name of the map (without '.txt').\n" +
                "The txt file must be placed in resources/map folder in the root directory")
                .setDefaultValue("maps");
        return form;
    }
}
