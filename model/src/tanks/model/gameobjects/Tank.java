package tanks.model.gameobjects;

import java.util.*;
import tanks.model.Position;

public class Tank extends GameObject {
    private Position pos;
    
    public Tank(Position pos) {
        super(pos);
    }
        
    public char getLetter() {
        return 'T';
    }
}
