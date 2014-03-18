package tanks.model;

import java.util.*;
import tanks.model.map.Map;
import tanks.model.gameobjects.GameObject;

public class GameModel {
    private Map map;
    private java.util.Map<Integer, GameObject> gameobjects;
    
    public GameModel() {
        
    }
    
    public Map getMap() {
        return map;
    }
}
