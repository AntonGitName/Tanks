package tanks.model;

import java.util.*;
import java.io.*;
import tanks.model.map.*;
import tanks.model.gameobjects.*;
import java.util.Arrays;

public class GameModelReader {
    static void parse(GameModel model, String filename) {
        
        tanks.model.map.Map map = model.getMap();

        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			String sCurrentLine;
            sCurrentLine = br.readLine();
            String[] dimensions = sCurrentLine.split(" ");
            
            
            map.setDimensions(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
            int width = map.getWidth();
            int height = map.getHeight();
            
            for (int i = 0; i < height; ++i) {
			    sCurrentLine = br.readLine();
			    String[] tags = sCurrentLine.split(" ");
			    
			    for (int j = 0; j < width; ++j)	{
			        Cell c;
			        switch (MapLegend.getMapLegend(tags[j])) {
			        case WATER:
			            c = new Water();
			            break;
			        case WOODENWALL:
			            c = new Woodenwall();
			            break;
			        case STONEWALL:
			            c = new Stonewall();
			            break;
			        case ASPHALT:
			            c = new Asphalt();
			            break;
			        default: ////// ERROR
			            c = new Asphalt();
			            break;
			        }
			        map.setCell(c, i, j);
			    }
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
