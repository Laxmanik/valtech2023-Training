package CoreJava.Day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import CoreJava.Day1.Point;
import CoreJava.Day1.Point3D;

public class SerialTest {

	public static void main(String[] args) throws Exception {
		Point p = new Point(2,3);
		System.out.println(p);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("objects")));
		oos.writeObject(p);
		oos.flush();
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("objects")));
		Point p1 = (Point) ois.readObject();
		System.out.println(p1);
		System.out.println(p==p1);
		
		//for point 3d
		Point3D p3 = new Point3D(20, 40, 10);
		System.out.println(p3);
		ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(new File("objects3d")));
		oos1.writeObject(p3);
		oos1.flush();
		oos1.close();
		
		ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(new File("objects3d")));
		Point3D p4 = (Point3D) ois1.readObject();
		System.out.println(p4);
		System.out.println(p3==p4);
	}
}
