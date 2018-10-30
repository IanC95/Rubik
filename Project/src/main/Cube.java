package main;

public class Cube {
	private Face[] faces;

	public Cube(Face[] faces) {
		this.faces = faces;
	}

	public Cube() {
		faces = new Face[6];
		faces[0] = FaceGen("G");
		faces[1] = FaceGen("W");
		faces[2] = FaceGen("B");
		faces[3] = FaceGen("Y");
		faces[4] = FaceGen("O");
		faces[5] = FaceGen("R");
	}

	public Cube(char[] cube) {
		faces = new Face[6];
		Tile[][] FaceArray;
		for(int k = 0; k < 6; k++) {
			FaceArray = new Tile[3][3];
			for(int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++){
					FaceArray[i][j] = new Tile(String.valueOf(cube[(k*9)+(i*3)+j]));
				}
			}
			faces[k] = new Face(FaceArray);
		}
	}
	
	public Face FaceGen(String Colour) {
		Tile[][] FaceArray = new Tile[3][3];
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++){
				FaceArray[i][j] = new Tile(Colour);
			}
		}
		Face returnVal = new Face(FaceArray);
		return returnVal;
	}
	
	public Face[] getFaces() {
		return faces;
	}
	
	public Face getFace(int i) {
		return faces[i];
	}

	public void setFaces(Face[] faces) {
		this.faces = faces;
	}
	
	public String BlankDisplay() {
		String returnValue = "   \n   \n   ";
		return returnValue;
	}
	
	public void RotateFace(int face, int times) {
		Tile[][] currentFace;
		Tile[][] newFace;
		if(times <0) {
			times = 3;
		}
		for(int k = 0; k<times; k++) {
			currentFace = faces[face].getTiles();
			newFace = new Tile[currentFace[0].length][currentFace.length];
			for (int i = 0; i < currentFace.length; i++) {
				for (int j = 0; j < currentFace[0].length; j++) {
					newFace[j][(currentFace.length-1)- i] = currentFace[i][j]; 
				}
			}
			faces[face].setTiles(newFace);
		}
	}
	
	
	public void HorizontalTurn(int row, boolean Clockwise) {
		int direction;
		int times;
		if(Clockwise == true) {
			direction = 1;
			times = 1;
		}else {
			direction = -1;
			times = -1;
		}
		Tile[] Current = new Tile[12];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				Current[(i*3)+j] = faces[i].getTiles()[row][j];
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				faces[i].setTiles(row, j, Current[((((i + direction)+4)%4)*3)+j]);
			}
		}
		
		if(row == 0) {
			RotateFace(4, times);
		}else if(row == 2) {
			RotateFace(5, -times);
		}
	}

	public void VerticalTurn(int column, boolean Clockwise) {
		Tile[] Current = new Tile[12];
		Face[] RelevantFaces = new Face[4];
		int direction, times;
		int l, m;
		if(Clockwise == true) {
			direction = 1;
			times = -1;
			l = 0;
			m = 1;
		}else {
			direction = -1;
			times = 1;
			l = 0;
			m = 3;
		}
		
		
		RelevantFaces[0] = faces[1];
		RelevantFaces[1] = faces[5];
		RelevantFaces[2] = faces[3];
		RelevantFaces[3] = faces[4];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == l || i == m) {
					Current[(i*3)+j] = RelevantFaces[i].getTiles()[j][column];
				}else if(i == 2) {
					Current[(i*3)+j] = RelevantFaces[i].getTiles()[2 - j][2 - column];
				}else {
					Current[(i*3)+j] = RelevantFaces[i].getTiles()[2 - j][column];
				}
			}
		}
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if(i != 2) {
					RelevantFaces[i].setTiles(j,column, Current[((((i + direction)+4)%4)*3)+j]);
				}else {
					RelevantFaces[i].setTiles(j,2 - column, Current[((((i + direction)+4)%4)*3)+j]);
				}
			}
		}
		
		if(column == 0) {
			RotateFace(0, times);
		}else if(column == 2) {
			RotateFace(2, -times);
		}
		
	}
	
	public void CrossTurn(int column, boolean Clockwise) {
		Tile[] Current = new Tile[12];
		Face[] RelevantFaces = new Face[4];
		int direction, times;
		if(Clockwise == true) {
			direction = -1;
			times = 1;
		}else {
			direction = 1;
			times = -1;
		}
		
		
		RelevantFaces[0] = faces[2];
		RelevantFaces[1] = faces[5];
		RelevantFaces[2] = faces[0];
		RelevantFaces[3] = faces[4];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 0) {
					Current[(i*3)+j] = RelevantFaces[i].getTiles()[j][column];
				}else if(i == 1){
					Current[(i*3)+j] = RelevantFaces[i].getTiles()[column][2-j];
				}else if(i == 2) {
					Current[(i*3)+j] = RelevantFaces[i].getTiles()[2-j][2 - column];
				}else {
					Current[(i*3)+j] = RelevantFaces[i].getTiles()[2-column][j];
				}
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 0) {
					RelevantFaces[i].setTiles(j,column, Current[((((i + direction)+4)%4)*3)+j]);
				}else if(i == 1){
					RelevantFaces[i].setTiles(column,2 - j, Current[((((i + direction)+4)%4)*3)+j]);
				}else if(i == 2) {
					RelevantFaces[i].setTiles(2 - j,2 - column, Current[((((i + direction)+4)%4)*3)+j]);
				}else{
					RelevantFaces[i].setTiles(2 - column,j, Current[((((i + direction)+4)%4)*3)+j]);
				}
			}
		}
		
		if(column == 0) {
			RotateFace(1, times);
		}else if(column == 2) {
			RotateFace(3, -times);
		}
	}
	
	@Override
	public String toString() {
		String returnVal = new String();
		
		for(int i = 0; i < 3; i++) {
			returnVal += "    "+ faces[4].toString().substring(i*3, i*3 + 3) +" \n";
		}
		returnVal += "\n";
		for(int i = 0; i < 3; i++) {
			returnVal += faces[0].toString().substring(i*3,i*3 + 3) + " "
				+ faces[1].toString().substring(i*3,i*3 + 3) + " "
				+ faces[2].toString().substring(i*3,i*3 + 3) + " "
				+ faces[3].toString().substring(i*3,i*3 + 3) + "\n";
		}
		returnVal += "\n";
		for(int i = 0; i < 3; i++) {
			returnVal += "    "+ faces[5].toString().substring(i*3, i*3 + 3) +"\n";
		}
		return returnVal;
	}


	
	public boolean equals(Cube otherCube) {
		for(int i = 0; i<6; i++) {
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++) {
					if(!(this.getFace(i).getTile(j, k).getColour().equals(otherCube.getFace(i).getTile(j, k).getColour()))) {
						return false;
					}
				}
			}
		}
		
		return true;
	}

	public boolean equals(String otherCube) {
		String thisCube = new String();
		for(int i = 0; i<6; i++) {
			for(int j = 0; j < 3; j++){
				for(int k = 0; k < 3; k++) {
						thisCube += this.getFace(i).getTile(j, k).getColour();
					}
				}
			}
		
		if(thisCube.equals(otherCube)) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
