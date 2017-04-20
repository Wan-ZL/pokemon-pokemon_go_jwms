package model;



import java.io.Serializable;



import controller.MapCreater;



public class Map implements Serializable{								// this class store the two maps. we can add more functions, like edit map

	

	private static final long serialVersionUID = -6496427290493586496L;

	

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

	

	public String getItemOnMap(int map, int i, int j) {      // return the Item on map, like tree or stone. return value is String

		return this.getMap(map)[i][j];

	}

}