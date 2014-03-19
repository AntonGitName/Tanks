package tanks.model;

import java.util.*;

public enum Direction {
    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);
    
    private Position pos;
    
    private Direction(int x, int y) {
        this.pos = new Position(x, y);
    }
    
    public Position getMove() {
        return pos;
    }
}
