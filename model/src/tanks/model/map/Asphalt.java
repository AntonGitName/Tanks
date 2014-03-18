package tanks.model.map;

import java.util.*;

public class Asphalt implements Cell {
    public boolean isFree() {
        return true;
    }
    
    public char getLetter() {
        return 'A';
    }
}
