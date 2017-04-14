package model;

import controller.MapCreater;

public class Map {								// this class store the two maps. we can add more functions, like edit map
	
	String[][] map1;
	String[][] map2;
	
	public Map(){
		MapCreater creater = new MapCreater();
		map1 = creater.getMap1();
		map2 = creater.getMap2();
	}
	
	public String[][] getMap(int i){		// return the whole map
		if(i == 1){
			return map1;
		}
		else{
			return map2;
		}
	}
}
