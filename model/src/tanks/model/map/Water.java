package tanks.model.map;

import java.util.*;

public class Water implements Cell {
    public boolean isFree() {
        return false;
    }
    
    public char getLetter() {
        return 'W';
    }
}
