public class Pentagon {
    Point A;
    Point B;
    Point C;
    Point D;
    Point E;
    
    public Pentagon(Point A, Point B, Point C, Point D, Point E) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.E = E;
    }
    
    public double perimeter() {
        return A.distance(B) + B.distance(C) + C.distance(D) + D.distance(E) + E.distance(A);
    }
    
    public boolean isRegular() {
        double dAB = A.distance(B);
        double dBC = B.distance(C);
        double dCD = C.distance(D);
        double dDE = D.distance(E);
        double dEA = E.distance(A);
        return (dAB == dBC) && (dBC == dCD) && (dCD == dDE) && (dDE == dEA);
    }
}
