import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuadrilateralTest {

    // Test the perimeter method with larger values
    @Test
    void testPerimeterLargeValues() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 100);
        Point p3 = new Point(100, 100);
        Point p4 = new Point(100, 0);
        Quadrilateral quadrilateral = new Quadrilateral(p1, p2, p3, p4);
        assertEquals(400.0, quadrilateral.perimeter());
    }

    // Test perimeter with points on negative coordinates
    @Test
    void testPerimeterNegativeCoordinates() {
        Point p1 = new Point(-1, -1);
        Point p2 = new Point(-1, 1);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(1, -1);
        Quadrilateral quadrilateral = new Quadrilateral(p1, p2, p3, p4);
        assertEquals(8.0, quadrilateral.perimeter());
    }

    // Test isRectangle with a non-axis-aligned rectangle
    @Test
    void testIsRectangleNonAligned() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(4, 2);
        Point p4 = new Point(3, 0);
        Quadrilateral quadrilateral = new Quadrilateral(p1, p2, p3, p4);
        assertTrue(quadrilateral.isRectangle()); // Diagonals and perpendicularity define the rectangle
    }

    // Test isSquare with floating point precision
    @Test
    void testIsSquareWithFloatingPoint() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1.000001);
        Point p3 = new Point(1.000001, 1.000001);
        Point p4 = new Point(1.000001, 0);
        Quadrilateral quadrilateral = new Quadrilateral(p1, p2, p3, p4);
        assertFalse(quadrilateral.isSquare()); // Small differences in lengths mean it's not a perfect square
    }

    // Test dotProduct with vectors that are parallel
    @Test
    void testDotProductParallelVectors() {
        double[] v1 = {1, 1};
        double[] v2 = {2, 2}; // Parallel vectors
        Quadrilateral quadrilateral = new Quadrilateral(null, null, null, null); // Dummy instance
        assertEquals(4.0, quadrilateral.dotProduct(v1, v2));
    }

    // Test dotProduct with opposite vectors
    @Test
    void testDotProductOppositeVectors() {
        double[] v1 = {1, 0};
        double[] v2 = {-1, 0}; // Opposite vectors
        Quadrilateral quadrilateral = new Quadrilateral(null, null, null, null); // Dummy instance
        assertEquals(-1.0, quadrilateral.dotProduct(v1, v2));
    }

    // Test isPerpendicular with very small floating-point differences
    @Test
    void testIsPerpendicularWithSmallFloatingPointDifferences() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0.0000001);
        Point p3 = new Point(0, 1);
        Quadrilateral quadrilateral = new Quadrilateral(null, null, null, null); // Dummy instance
        assertTrue(quadrilateral.isPerpendicular(p1, p2, p3)); // Almost perpendicular due to small floating point error
    }

    // Test isPerpendicular with negative coordinates
    @Test
    void testIsPerpendicularNegativeCoordinates() {
        Point p1 = new Point(-1, -1);
        Point p2 = new Point(-1, 0);
        Point p3 = new Point(0, 0);
        Quadrilateral quadrilateral = new Quadrilateral(null, null, null, null); // Dummy instance
        assertTrue(quadrilateral.isPerpendicular(p1, p2, p3)); // Right angle with negative coordinates
    }

    // Test isRectangle with points that almost form a rectangle but aren't exact
    @Test
    void testIsAlmostRectangle() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(2.001, 2); // Small variation in the x-coordinate
        Point p4 = new Point(2, 0);
        Quadrilateral quadrilateral = new Quadrilateral(p1, p2, p3, p4);
        assertFalse(quadrilateral.isRectangle()); // Slight deviation from being a rectangle
    }

    // Test for edge case with minimal differences in angles
    @Test
    void testIsRectangleMinimalAngleDifferences() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(1.000001, 1);
        Point p4 = new Point(1, 0);
        Quadrilateral quadrilateral = new Quadrilateral(p1, p2, p3, p4);
        assertFalse(quadrilateral.isRectangle()); // Very minimal difference makes it non-rectangular
    }

    // Test dotProduct with zero vectors
    @Test
    void testDotProductWithZeroVectors() {
        double[] v1 = {0, 0};
        double[] v2 = {0, 0}; // Zero vectors
        Quadrilateral quadrilateral = new Quadrilateral(null, null, null, null); // Dummy instance
        assertEquals(0.0, quadrilateral.dotProduct(v1, v2));
    }

    // Test isSquare with very large values
    @Test
    void testIsSquareWithLargeValues() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1000000);
        Point p3 = new Point(1000000, 1000000);
        Point p4 = new Point(1000000, 0);
        Quadrilateral quadrilateral = new Quadrilateral(p1, p2, p3, p4);
        assertTrue(quadrilateral.isSquare());
    }

    // Test isPerpendicular with almost perpendicular points
    @Test
    void testIsAlmostPerpendicular() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0.000001); // Almost horizontal
        Point p3 = new Point(0, 1);
        Quadrilateral quadrilateral = new Quadrilateral(null, null, null, null); // Dummy instance
        assertFalse(quadrilateral.isPerpendicular(p1, p2, p3)); // Not exactly perpendicular
    }
}
