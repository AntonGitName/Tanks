// import java.io.FileReader
// import java.io.File;
// import java.io.BufferedReader;
import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;

import static java.lang.System.out;

class game_model {
    private static map_model map;
    private static Set<game_object_model> game_objects = new HashSet<game_object_model>();
    private static Random generator = new Random();
    
    public static void main(String[] args) {
        map = new map_model("map.txt");
        
        List<Position> freePositions = map.getFreePos();
    
        int teams = 2;
        for (int i = 0; i < teams; ++i) {    
            if (! freePositions.isEmpty()) {
                int index = generator.nextInt(freePositions.size());
                game_objects.add(new tank_model(freePositions.get(index), i));
                freePositions.remove(index)
            }
        }

        for (int i = 0; i < 3; ++i) {
            if (! freePositions.isEmpty()) {
                int index = generator.nextInt(freePositions.size());
                game_objects.add(new bonus_model(freePositions.get(index), 1));
            }
        }
        
    }
    
    public static void print() {
        List<List<char>> mapAndObjects = new ArrayList<ArrayList<char>>(map.height()); 
        for (int i = 0; i < map.height(); ++i) {
            mapAndObjects.add(new ArrayList(map.width()));
            for (int j = 0; j < map.width(); ++j) {
                if (map.isFree(i, j)) {
                    mapAndObjects.get(i).set(j, ' ');
                } else {
                    mapAndObjects.get(i).set(j, '*');
                }
            }
        }
        
        for (game_object_model obj : game_objects) {
            int x = obj.getPos().getX();
            int y = obj.getPos().getY();
            mapAndObjects.get(y).set(x, obj.getRepresentation());
        }
        
        for (int i = 0; i < map.height(); ++i) {
            for (int j = 0; j < map.width(); ++j) {
                out.print(mapAndObjects.get(i).get(j));
            }
            out.print("\n");
        }
        
    }
    
}

interface cell_model {
    public boolean isFree();
}

class road_model implements cell_model
{
    public boolean isFree() {
        return true;
    }
}

class wall_model implements cell_model
{
    public boolean isFree() {
        return false;
    }
}

class game_object_model {
    private Position pos;
    
    public game_object_model(Position p1) {
        pos = p1;
    }
    
    public game_object_model(int x, int y) {
        pos = new Position(x, y);
    }
    
    public char getRepresentation();
    
    public Position getPos() {
        return pos;
    }
}

class tank_model extends game_object_model {

    private int team;
    
    public tank_model(Position p1, int t) {
        super(p1);
        team = t;
    }

    public tank_model(int x, int y, int t) {
        super(x, y);
        team = t;
    }
    
    public char getRepresentation() {
        return 'T';
    }
}

class flag_model extends game_object_model {
    
    int team;
    
    public flag_model(Position p1, int t) {
        super(p1);
        team = t;
    }

    public flag_model(int x, int y, int t) {
        super(x, y);
        team = t;
    }
    
    public char getRepresentation() {
        return 'F';
    }
}

class bonus_model extends game_object_model {
    
    int type;
    
    public bonus_model(Position p1, int t) {
        super(p1);
        type = t;
    }
    
    public bonus_model(int x, int y, int t) {
        super(x, y);
        type = t;
    }
    
    public char getRepresentation() {
        return 'B';
    }
}

class map_model {
    private ArrayList<ArrayList<cell_model>> cells;
    private int width;
    private int height;
    
    public map_model(String filename) {
        File file = new File(filename);       
        cells = new ArrayList<ArrayList<cell_model>>();
        BufferedReader reader = null;
        height = 0;        
        
        try {
            reader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = reader.readLine()) != null) {
                cells.add(new ArrayList<cell_model>());
                for (String s : text.split(" ")) {
                    int cell_type = Integer.parseInt(s);

                    if (cell_type == 0) {
                        cells.get(height).add(new road_model());
                    } else if (cell_type == 1) {
                        cells.get(height).add(new wall_model());
                    }
                    // out.print(cells.get(height).get(cells.get(height).size() - 1).isFree());
                    // out.print(" ");
                }
                ++height;
                // out.print("\n");
            }
            width = cells.get(height - 1).size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }       
    }
    
    public boolean isFree(int x, int y) {
        return cells.get(x).get(y).isFree();
    }
    
    public int width() {
        return width;
    }
    
    public int height() {
        return height;
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

class Position {
    private int x;
    private int y;
    
    public Position(int x1, int y1) {
        x = x1;
        y = y1;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x1) {
        x = x1;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y1) {
        y = y1;
    }
}
