package tanks.model;

import java.util.*;
import tanks.model.*;

class MainClass {
    public static void main(String[] args) {
        GameModel m = new GameModel();
        GameModelReader.parse(m, "map.txt");
        ModelTextView view = new ModelTextView(m);
        
        m.addTank("Player");
        
        int i = 0;
        
        System.out.println(m.getMap().isFree(1, 2));
        
        
        Scanner keyboard = new Scanner(System.in);
        while (i != 5) {
            view.print();
            String text = keyboard.nextLine();
            i = Integer.parseInt(text);
            switch (i) {
            case 8 :
                m.moveTank("Player", Direction.UP);
                break;
            case 4 :
                m.moveTank("Player", Direction.LEFT);
                break;
            case 2 :
                m.moveTank("Player", Direction.DOWN);
                break;
            case 6 :
                m.moveTank("Player", Direction.RIGHT);
                break;
            default :
                break;
            }
        }
        view.print();
        
    }
}
