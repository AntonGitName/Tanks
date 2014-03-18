package tanks.model.map;

import java.util.*;
import tanks.model.Position;

public class Map {
    private int width;
    private int height;
    private List<ArrayList<Cell>> matrix;
    
    public Map() {
        setDimensions(0, 0);
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
        
        matrix = new ArrayList<ArrayList<Cell>>();
        for (int i = 0; i < width; ++i) {
            matrix.add(new ArrayList<Cell>());
            for (int j = 0; j < height; ++j) {
                matrix.get(i).add(new Asphalt());
            }
        }
    }
    
    public void setCell(Cell c, int x, int y) {       
        matrix.get(x).set(y, c);
    }
    
    public char getLetter(int x, int y) {
        return matrix.get(x).get(y).getLetter();
    }
    
    public boolean isFree(int x, int y) {
        return matrix.get(x).get(y).isFree();
    }
    
    public List<Position> getFreePos() {
        List<Position> freePos = new ArrayList<Position>();
        
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (isFree(i, j)) {
                    freePos.add(new Position(i, j));
                }
            }
        }
        return freePos;
    }
}
