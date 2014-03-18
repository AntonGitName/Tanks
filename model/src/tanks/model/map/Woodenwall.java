package tanks.model.map;

import java.util.*;

public class Woodenwall implements Cell {
    public boolean isFree() {
        return false;
    }
    
    public char getLetter() {
        return 'O';
    }
}
