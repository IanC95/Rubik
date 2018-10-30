package main;

public class Face {
	private boolean solved;
	private Tile[][] tiles;
	
	public Face(Tile[][] tiles) {
		this.solved = false;
		this.tiles = tiles;
	}
	
	public Tile getTile(int i, int j) {
		return tiles[i][j];
	}

	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	public void setTiles(int row, int column, Tile tile) {
		this.tiles[row][column] = tile;
	}
	
	
	@Override
	public String toString() {
		String returnVal = tiles[0][0].toString() + tiles[0][1].toString() 
					+ tiles[0][2].toString()  + tiles[1][0].toString() 
					+ tiles[1][1].toString() + tiles[1][2].toString() 
					+ tiles[2][0].toString() + tiles[2][1].toString() + tiles[2][2].toString();
		return returnVal;
	}
	
}
