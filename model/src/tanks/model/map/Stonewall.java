package tanks.model.map;

import java.util.*;

public class Stonewall implements Cell {
    public boolean isFree() {
        return false;
    }
    
    public char getLetter() {
        return 'S';
    }
}
