package main;

public class Tile {
	private String colour;

	public Tile(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return colour;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	
}
