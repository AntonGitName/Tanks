package tanks.model;

import java.util.*;

public class ModelTextView {
    private GameModel model;
    
    public ModelTextView(GameModel model) {
        this.model = model;
    }
    
    public void setModel(GameModel model) {
        this.model = model;
    }
    
    public void print() {

        int width = model.getWidth();
        int height = model.getHeight();
        
        System.out.print("+");
        for (int i = 0; i < width; ++i) {
            System.out.print("-");
        }
        System.out.print("+\n");
        for (int i = 0; i < height; ++i) {
            System.out.print("|");
            for (int j = 0; j < width; ++j) {
                System.out.print(model.getLetter(i, j));
            }
            System.out.print("|\n");
        }
        System.out.print("+");
        for (int i = 0; i < width; ++i) {
            System.out.print("-");
        }
        System.out.print("+\n");
    }
}
