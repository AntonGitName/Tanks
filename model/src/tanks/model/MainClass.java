package tanks.model;

import java.util.*;

class MainClass {
    public static void main(String[] args) {
        GameModel m = new GameModel();
        GameModelReader.parse(m, "map.txt");
        ModelTextView view = new ModelTextView(m);
        
        m.addTank("Player");
        
        int i = 0;
        
        Scanner keyboard = new Scanner(System.in);
        while (i != 5) {
            view.print();
            String text = keyboard.nextLine();
            try {
                i = Integer.parseInt(text);
            } catch(NumberFormatException e) { 
                if (text.equals(" ")) {
                    m.shoot("Player");
                }
            }
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
            m.tick();
        }
        view.print();
        
    }
}
