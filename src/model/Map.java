package model;

/*import controller.MapCreater;

public class Map {								// this class store the two maps. we can add more functions, like edit map
	
	String[][] map1;
	String[][] map2;
	String[][] map3;
	
	public Map(){
		MapCreater creater = new MapCreater();
		map1 = creater.getMap1();
		map2 = creater.getMap2();
		map3 = creater.getMap3();
	}
	
	public String[][] getMap(int i){		// return the whole map
		if(i == 0){
			return map1;
		}
		else if(i == 1){
			return map2;
		}
		else{
			return map3;
		}
	}
	
	public String getLocation(int x, int y){
		return map[x][y];
	}
}*/
import java.io.Serializable;

public class Map implements Serializable {

	private static final long serialVersionUID = -7371246715182810289L;
	private String[][] map;

	//constructor
	public Map(String[][] map) {
		this.map = map;
	}

	//return the map
	public String[][] getMap() {
		return map;
	}

	//return the location in the map
	public String getLocation(int x, int y) {
		return map[x][y];
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				str += map[i][j];
			}
			str += "\n";
		}
		return str;
	}

}