package CoreJava.Day1;

public class Point3D extends Point {

	public static final Point3D ORIGIN=new Point3D();
	
	
	private int z;
	
	public Point3D() {
		
	}
	
	public Point3D(int x, int y, int z) {
		super(x,y);
		System.out.println("In constructor 0f point3d");
		this.z=z;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Point3D p=(Point3D) obj;
		return p.x==x && p.y==y && p.z==z;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "X="+x+" Y="+y+" Z="+z+" Distance="+distance();
	}
	
	public double distance(int x, int y, int z) {
		int diffx=this.x-x;
		int diffy=this.y-y;
		int diffz=this.z-z;
		return Math.sqrt(diffx*diffx + diffy*diffy + diffz*diffz);
	}
	
	@Override
	public double distance() {
		// TODO Auto-generated method stub
		System.out.println("3d");
		return Math.sqrt(x*x + y*y +z*z);
	}
	
	public static void main(String[] args) {
		ORIGIN.x=10;
		System.out.println(Point.ORIGIN.distance());
		System.out.println(ORIGIN.distance());
		Point3D p=new Point3D(10,20,30);
		double dis=p.distance(new Point(20,40));
		System.out.println(p);
		/*
		p.distance();
		p=new Point();
		p.distance();
		Point3D p = new Point3D();
		p.x=10;
		p.y=20;
		p.z=30;
		System.out.println(p);*/
	}
}
