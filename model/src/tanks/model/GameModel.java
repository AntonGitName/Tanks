package tanks.model;

import java.util.*;
import tanks.model.map.Map;
import tanks.model.gameobjects.GameObject;

public class GameModel {
    private Map map;
    private java.util.Map<Integer, GameObject> gameobjects;
    
    public GameModel() {
        map = new Map();
        gameobjects = new HashMap<Integer, GameObject>();
    }
    
    public Map getMap() {
        return map;
    }
}
