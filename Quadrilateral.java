package lab4;
public class Quadrilateral {
	Point A;
	Point B;
	Point C;
	Point D;
	
	public Quadrilateral(Point A, Point B, Point C, Point D){
		// A and B must be adjacent, so for BC, CD, AD
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
	}
	
	public double perimeter() {
		return A.distance(B) + B.distance(C) + C.distance(D) + D.distance(A);
	}
	
	double dotProduct(double[] v1, double[] v2) {
	    return v1[0] * v2[0] + v1[1] * v2[1];
	}
	
	private boolean isPerpendicular(Point p1, Point p2, Point p3) {
	    double[] v1 = {p2.x - p1.x, p2.y - p1.y};
	    double[] v2 = {p3.x - p2.x, p3.y - p2.y};
	    return dotProduct(v1, v2) == 0;
	}
	
	public boolean isRectangle() {
		double ab = A.distance(B);
		double ac = A.distance(C);
		double ad = A.distance(D);
		double bc = B.distance(C);
		double bd = B.distance(D);
		double cd = C.distance(D);
		boolean oppositeSidesEqual = (ab == cd && bc == ad);
		boolean diagonalsEqual = (ac == bd);
		boolean perpendicular = isPerpendicular(A, B, C) && isPerpendicular(B, C, D) &&
				isPerpendicular(C, D, A) && isPerpendicular(D, A, B);
		 
		return oppositeSidesEqual && diagonalsEqual && perpendicular;
	}
	
	public boolean isSquare() {
		if (!isRectangle()) {
			return false;
		}
		return (A.distance(B) == B.distance(C)) && (B.distance(C) == C.distance(D)) && (C.distance(D) == D.distance(A));
	}

}
