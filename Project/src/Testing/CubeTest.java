package Testing;
import main.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CubeTest {
	
	@Test
	void DefaulGen() {
		Cube testCube = new Cube();
		String cube = new String("GGGGGGGGGWWWWWWWWWBBBBBBBBBYYYYYYYYYOOOOOOOOORRRRRRRRR");
		
		assertTrue(testCube.equals(cube));
	}
	
	@Test
	void Horizontal1() {
		Cube testCube = new Cube();
		String cube = new String("GGGWWWGGGWWWBBBWWWBBBYYYBBBYYYGGGYYYOOOOOOOOORRRRRRRRR");
		
		testCube.HorizontalTurn(1, true);
		//System.out.println(testCube);
		assertTrue(testCube.equals(cube));
		
	}
	
	@Test
	void Vertical1() {
		Cube testCube = new Cube();
		String cube = new String("GGGGGGGGGWOWWOWWOWBBBBBBBBBYRYYRYYRYOYOOYOOYORWRRWRRWR");
		
		testCube.VerticalTurn(1, true);
		//System.out.println(testCube);
		assertTrue(testCube.equals(cube));
		
	}
	
	@Test
	void Cross1() {
		Cube testCube = new Cube();
		String cube = new String("GRGGRGGRGWWWWWWWWWBOBBOBBOBYYYYYYYYYOOOGGGOOORRRBBBRRR");
		
		testCube.CrossTurn(1, true);
		//System.out.println(testCube);
		assertTrue(testCube.equals(cube));
		
	}
	
	@Test
	void Newton2nd() {
		Cube testCube = new Cube();
		String cube = new String("GGGWWWGGGWWWBBBWWWBBBYYYBBBYYYGGGYYYOOOOOOOOORRRRRRRRR");
		
		testCube.HorizontalTurn(1, true);
		testCube.VerticalTurn(1, true);
		testCube.CrossTurn(1, true);
		testCube.HorizontalTurn(0, true);
		testCube.HorizontalTurn(2, true);
		testCube.VerticalTurn(0, true);
		testCube.VerticalTurn(2, true);
		testCube.CrossTurn(0, true);
		testCube.CrossTurn(2, true);
		testCube.CrossTurn(2, false);
		testCube.CrossTurn(0, false);
		testCube.VerticalTurn(2, false);
		testCube.VerticalTurn(0, false);
		testCube.HorizontalTurn(2, false);
		testCube.HorizontalTurn(0, false);
		testCube.CrossTurn(1, false);
		testCube.VerticalTurn(1, false);
		testCube.HorizontalTurn(1, false);
		
		
		assertTrue(testCube.equals(cube));
	}
}
