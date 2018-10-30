package Testing;
import main.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CubeTest {
	
	String testCubeString = new String("YBYBYGYRYWWWWWWWWWGOROGBGROGOBGBOGGBRYBYRGRRROYOYOBORB");
	
	@Test
	void DefaulGen() {
		Cube testCube = new Cube();
		String cube = new String("GGGGGGGGGWWWWWWWWWBBBBBBBBBYYYYYYYYYOOOOOOOOORRRRRRRRR");
		
		assertTrue(testCube.equals(cube));
	}
	
	@Test
	void ScrambleGen() {
		Cube testCube = new Cube(testCubeString.toCharArray());
		String cube = new String(testCubeString);
		assertTrue(testCube.equals(cube));
	}
	
	@Test
	void HorizontalReversal() {
		Cube testCube = new Cube(testCubeString.toCharArray());
		String cube = new String(testCubeString);
		testCube.HorizontalTurn(0, true);
		testCube.HorizontalTurn(1, true);
		testCube.HorizontalTurn(2, true);
		testCube.HorizontalTurn(0, false);
		testCube.HorizontalTurn(1, false);
		testCube.HorizontalTurn(2, false);
		//System.out.println(testCube);
		assertTrue(testCube.equals(cube));
	}
	
	@Test
	void VerticalReversal() {
		Cube testCube = new Cube(testCubeString.toCharArray());
		String cube = new String(testCubeString);
		testCube.VerticalTurn(2, true);
		testCube.VerticalTurn(2, false);
		testCube.VerticalTurn(1, true);
		testCube.VerticalTurn(1, false);
		testCube.VerticalTurn(0, true);
		testCube.VerticalTurn(0, false);
		//System.out.println(testCube);
		assertTrue(testCube.equals(cube));
	}
	
	@Test
	void CrossReversal() {
		Cube testCube = new Cube(testCubeString.toCharArray());
		String cube = new String(testCubeString);
		testCube.CrossTurn(0, true);
		testCube.CrossTurn(1, true);
		testCube.CrossTurn(2, true);
		testCube.CrossTurn(0, false);
		testCube.CrossTurn(1, false);
		testCube.CrossTurn(2, false);
		//System.out.println(testCube);
		assertTrue(testCube.equals(cube));
	}
	
	@Test
	void ScrambleHorizontalTest() {
		Cube testCube = new Cube(testCubeString.toCharArray());
		String cube = new String("WWWWWWWWWGOROGBGROGOBGBOGGBYBYBYGYRYRYRRRYRGBOBBYOROYO");
		testCube.HorizontalTurn(0, true);
		testCube.HorizontalTurn(1, true);
		testCube.HorizontalTurn(2, true);
		//System.out.println(testCube);
		assertTrue(testCube.equals(cube));
	}
	
	@Test
	void ScrambleVerticalTest() {
		Cube testCube = new Cube(testCubeString.toCharArray());
		String cube = new String("YGYBYRYBYOYOYOBORBGOGRGOOBRRRRGRYBYRWWWWWWWWWBGGOBGBOG");
		testCube.VerticalTurn(0, true);
		testCube.VerticalTurn(1, true);
		testCube.VerticalTurn(2, true);
		//System.out.println(testCube);
		assertTrue(testCube.equals(cube));
	}
	
	@Test
	void ScrambleCrossTest() {
		Cube testCube = new Cube(testCubeString.toCharArray());
		String cube = new String("OYOROYBBOWWWWWWWWWRYRRRYRGBBOBOBGGGGYBYRYBYGYGOGRGOOBR");
		testCube.CrossTurn(0, true);
		testCube.CrossTurn(1, true);
		testCube.CrossTurn(2, true);
		//System.out.println(testCube);
		assertTrue(testCube.equals(cube));
	}
}
