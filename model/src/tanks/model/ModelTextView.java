package tanks.model;

import java.util.*;
import tanks.model.map.Map;
import tanks.model.gameobjects.GameObject;

public class ModelTextView {
    private GameModel model;
    
    public ModelTextView(GameModel model) {
        this.model = model;
    }
    
    public void setModel(GameModel model) {
        this.model = model;
    }
    
    public void print() {
        tanks.model.map.Map map = model.getMap();
        int width = map.getWidth();
        int height = map.getHeight();
        
        char[][] matrix = new char[height][];
        for (int i = 0; i < height; ++i) {
            matrix[i] = new char[width];
        }
        
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                matrix[i][j] = map.getLetter(i, j);
            }
        }
        
        for (GameObject obj : model.getGameObjects()) {
            matrix[obj.getPosition().getX()][obj.getPosition().getY()] = obj.getLetter();
        }
        
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                System.out.print(matrix[i][j]);
            }
            System.out.print("\n");
        }
    }
}
