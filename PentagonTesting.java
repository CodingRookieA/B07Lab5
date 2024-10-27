import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static java.lang.Math.*;

class PentagonTesting {

	@Test
	void testPerimeter() {
		Point A = new Point(0, 0);
		Point B = new Point(1, 0);
		Point C = new Point(1.5, Math.sqrt(0.75));
		Point D = new Point(0.5, Math.sqrt(1.75));
		Point E = new Point(-0.5, Math.sqrt(0.75));
		Pentagon pentagon = new Pentagon(A, B, C, D, E);
		assertTrue(pentagon.perimeter() == 5.198828917876131);
	}
	
	@Test
	void testRegular() {
		Point A = new Point((sqrt(5) - 1) / 4, sqrt(10 + 2 * sqrt(5)) / 4);
		Point B = new Point(1, 0);
		Point C = new Point((sqrt(5) - 1) / 4, -sqrt(10 + 2 * sqrt(5)) / 4);
		Point D = new Point(-(sqrt(5) + 1) / 4, -sqrt(10 - 2 * sqrt(5)) / 4);
		Point E = new Point(-(sqrt(5) + 1) / 4, sqrt(10 - 2 * sqrt(5)) / 4);
		Pentagon pentagon = new Pentagon(A, B, C, D, E);
		assertTrue(pentagon.isRegular());
	}
	
	@Test
	void testNotRegular() {
		Point A = new Point(0, 0);
		Point B = new Point(1, 0);
		Point C = new Point(1.5, Math.sqrt(0.75));
		Point D = new Point(0.5, Math.sqrt(1.75));
		Point E = new Point(-0.5, Math.sqrt(0.75));
		Pentagon pentagon = new Pentagon(A, B, C, D, E);
		assertFalse(pentagon.isRegular());
	}
	
}
