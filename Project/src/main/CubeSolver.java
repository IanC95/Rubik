package main;

public class CubeSolver {

	public static void main(String[] args) {
		Cube Cube1 = new Cube();
		System.out.println(Cube1);
		Cube1.HorizontalTurn(0, true);
		System.out.println(Cube1);
		Cube1.HorizontalTurn(1, false);
		Cube1.HorizontalTurn(1, false);
		Cube1.VerticalTurn(0, true);
		Cube1.HorizontalTurn(1, false);
		Cube1.HorizontalTurn(0, true);
		Cube1.VerticalTurn(0, true);
		Cube1.CrossTurn(0, false);

		
	}
	
	public int solve(Cube inCube) {
		int moves = 0;
		
		return moves;
	}
}
