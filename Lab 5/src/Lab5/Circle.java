package Lab5;

/*
 * Hey what's up Sergey,hope your exams went well
 * Couple things to notice:
 * 1. Whenever Pi is involved, we simply use 3.14
 * 2. When you write a test, make sure that this file and Point.java are in the same folder
 * 3. When you're done, pls dm on discord
 * 4. Thanks, have fun!
 */

public class Circle implements Comparable<Circle>{
    Point center;
    double radius;
    /*
     * Constructor class of circle
     */
    public Circle(Point p, double r){
        center = p;
        radius = r;
    }

    /*
     * Compute the area of a given circle
     * Note for simplicity, we replace Pi with 3.14
     */
    public double computeArea(){
        return radius * radius * 3.14;
    }

    public double computeCircumfrence(){
    	return 2 * 3.14 * radius;
    }
    
    @Override
    public boolean equals(Object o) {
    	if(o == null) {
    		return false;
    	}
    	
    	if(!(o instanceof Circle)) {
    		return false;
    	}
    	
    	Circle other = (Circle) o;
    	
    	//Return true iff two circles have the same center and radius
    	return this.center.x == other.center.x && this.center.y == other.center.y && this.radius == other.radius;
    	
    }

	@Override
	public int compareTo(Circle o) {
		return (int)(this.radius - o.radius);
	}
}
