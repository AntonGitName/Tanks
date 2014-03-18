package tanks.model.gameobjects;

import java.util.*;
import tanks.model.Position;

public class GameObject {
    private Position pos;
    
    public GameObject(Position pos) {
        this.pos = pos;
    }
    
    public Position getPosition() {
        return pos;
    }
    
    public void setPosition(Position pos) {
        this.pos = pos;
    }
    
    public char getLetter() {
        return '*';
    }
}
