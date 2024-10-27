package lab4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

    @Test
    public void testComputeArea() {
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 3.0);
        double expectedArea = 3.0 * 3.0 * 3.14; // Using 3.14 instead of Math.PI
        assertEquals(expectedArea, circle.computeArea(), "The area calculation is incorrect");
    }

    @Test
    public void testEquals_SameCircle() {
        Point center = new Point(0, 0);
        Circle circle1 = new Circle(center, 5.0);
        Circle circle2 = new Circle(new Point(0, 0), 5.0);
        assertTrue(circle1.equals(circle2), "Circles with the same center and radius should be equal");
    }

    @Test
    public void testEquals_DifferentRadius() {
        Point center = new Point(0, 0);
        Circle circle1 = new Circle(center, 5.0);
        Circle circle2 = new Circle(center, 6.0);
        assertFalse(circle1.equals(circle2), "Circles with different radii should not be equal");
    }

    @Test
    public void testEquals_DifferentCenter() {
        Circle circle1 = new Circle(new Point(0, 0), 5.0);
        Circle circle2 = new Circle(new Point(1, 1), 5.0);
        assertFalse(circle1.equals(circle2), "Circles with different centers should not be equal");
    }

    @Test
    public void testEquals_NullObject() {
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 5.0);
        assertFalse(circle.equals(null), "Circle should not be equal to null");
    }

    @Test
    public void testEquals_DifferentObjectType() {
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 5.0);
        assertFalse(circle.equals(center), "Circle should not be equal to an object of a different type");
    }

    @Test
    public void testCompareTo_SameRadius() {
        Point center1 = new Point(0, 0);
        Point center2 = new Point(5, 3);
        Circle circle1 = new Circle(center1, 5.0);
        Circle circle2 = new Circle(center2, 5.0);
        assertEquals(0, circle1.compareTo(circle2), "Circles with the same radius should be equal in comparison");
    }

    @Test
    public void testCompareTo_LargerRadius() {
        Point center1 = new Point(2, 4);
        Point center2 = new Point(2, 3);
        Circle circle1 = new Circle(center1, 6.0);
        Circle circle2 = new Circle(center2, 5.0);
        assertTrue(circle1.compareTo(circle2) > 0, "Circle with a larger radius should be greater in comparison");
    }

    @Test
    public void testCompareTo_SmallerRadius() {
        Point center1 = new Point(3, 0);
        Point center2 = new Point(5, 1);
        Circle circle1 = new Circle(center1, 4.0);
        Circle circle2 = new Circle(center2, 5.0);
        assertTrue(circle1.compareTo(circle2) < 0, "Circle with a smaller radius should be lesser in comparison");
    }
}