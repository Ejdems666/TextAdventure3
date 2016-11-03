package adv.map;

import adv.Room;

/**
 * Created by Ejdems on 28/10/2016.
 */
public class MapGeneratorException extends Exception {
    public MapGeneratorException(int roomNumber,String message) {
        super(message+" When parsing room number "+roomNumber);
    }
}
