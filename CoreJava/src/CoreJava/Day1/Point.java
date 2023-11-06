/* Conventions to write program
 * 1. Constants
 * 2. Static Block
 * 3. Variables
 * 4. Constructors
 * 5. Methods
 */


package CoreJava.Day1;
import java.io.Serializable;

import CoreJava.Day2.*;
public class Point implements Comparable<Point>,PointArithmetic, Serializable{
	
	public static final Point ORIGIN=new Point();
	
	static { /* ORIGIN can be initialized by the way*/
		ORIGIN.x=1000;
		ORIGIN.y=2000;
		System.out.println(ORIGIN);
	}
	
	protected int x;
	transient protected int y;
	
	public Point() {
	System.out.println("Point Method");	
	}
	
	public Point(int x, int y) {
		//super();
		System.out.println("In constructor of point");
		this.x=x;
		this.y=y;
		}
	
	@Override
	public int compareTo(Point o) {
		
		return (x-o.x)==0 ? (y-o.y): (x-o.x) ; //ternary operator
	}
	
	
	
	public boolean equals(Object obj) { /*it compares and checks whether both the objects are same*/
		// TODO Auto-generated method stub
		Point p=(Point) obj;            //type casting
		return p.x==x &&  p.y==y;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "X="+x+" Y="+y+" Distance=" +distance();
	}
	
	public double distance(Point other) {
		System.out.println("Distance with another point");
		return distance(other.x, other.y);
	}
	
	public double distance(int x, int y) {
		System.out.println("Distance in point");
		int diffx=this.x - x;
		int diffy=this.y-y;
		return Math.sqrt(diffx*diffx + diffy*diffy);
	}
	
	public double distance() {
		int diffx=x-ORIGIN.x;
		int diffy=y-ORIGIN.y;
		return Math.sqrt(x*x + y*y);
	}
	
	
	
	public static void main(String[] args) {
//		Point p =new Point();
//		p.x=10;
//		p.y=20;
//		System.out.println(p);
		Point p2=new Point(2,3);
		Point p3=new Point(3,2);
		Point p1=new Point();
		PointArithmetic p4=new Point();
		p4.addPoint(p2, p3, p1);
		System.out.println("X = "+p1.x+" Y = "+p1.y);
		p4.subPoint(p2, p3, p1);
		System.out.println("X = "+p1.x+" Y = "+p1.y);
		System.out.println(p4.distance(p2,p3));
	}

	@Override
	public Point addPoint(Point obj1, Point obj2, Point obj3) {
		obj3.x= obj1.x + obj2.x;
		obj3.y= obj1.y + obj2.y;
		return obj3;
	}

	@Override
	public Point subPoint(Point obj1, Point obj2, Point obj3) {
		obj3.x= obj1.x - obj2.x;
		obj3.y= obj1.y - obj2.y;
		return obj3;
	}

	@Override
	public double distance(Point obj1, Point obj2) {
		double x = (obj1.x-obj2.x);
		double y = (obj1.y  - obj2.y);
		return Math.sqrt(x*x + y*y);
	}
}
