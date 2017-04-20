package model;


import java.io.Serializable;

import controller.MapCreater;


public class Map implements Serializable{								// this class store the two maps. we can add more functions, like edit map
	
	private static final long serialVersionUID = -6496427290493586496L;
	
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

	
	public String getItemOnMap(int map, int i, int j) {      // return the Item on map, like tree or stone. return value is String
		return this.getMap(map)[i][j];
	}
}

