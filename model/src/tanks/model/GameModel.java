package tanks.model;

import java.util.*;
import tanks.model.map.Map;
import tanks.model.gameobjects.*;

public class GameModel {
    private Map map;
    private java.util.Map<String, GameObject> gameobjects;
    private Random r = new Random();
    
    public GameModel() {
        map = new Map();
        gameobjects = new HashMap<String, GameObject>();
    }
    
    public Map getMap() {
        return map;
    }
    
    public Collection<GameObject> getGameObjects() {
        return gameobjects.values();
    }
    
    public boolean addTank(String id) {
        List<Position> freePos = map.getFreePos();
        if (freePos.isEmpty()) {
            return false;
        } else {
            Position pos = freePos.get(r.nextInt(freePos.size()));
            gameobjects.put(id, new Tank(pos));
            return true;
        }
    }
    
    public void moveTank(String id, Direction d) {
        GameObject tank = gameobjects.get(id);
        Position p = tank.getPosition();
        int newx = p.getX() + d.getMove().getX();
        int newy = p.getY() + d.getMove().getY();
        
        if (map.isFree(newx, newy)) {
            tank.setPosition(new Position(newx, newy));
        }
    }
}
