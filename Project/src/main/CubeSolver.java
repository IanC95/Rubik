package main;

public class CubeSolver {

	public static void main(String[] args) {
		//Cube Cube1 = new Cube();
		Cube Cube1 = new Cube("YBYBYGYRYWWWWWWWWWGOROGBGROGOBGBOGGBRYBYRGRRROYOYOBORB".toCharArray());
		Cube Cube2 = new Cube("YBYBYGYRYWWWWWWWWWGOROGBGROGOBGBOGGBRYBYRGRRROYOYOBORB".toCharArray());
		System.out.println(Cube1);
		Cube1.VerticalTurn(2, true);
		//System.out.println(Cube1);
		Cube1.VerticalTurn(2, false);
		System.out.println(Cube1);
		System.out.println(Cube1.equals(Cube2));
		
	}
	
	public int solve(Cube inCube) {
		int moves = 0;
		
		return moves;
	}
}
