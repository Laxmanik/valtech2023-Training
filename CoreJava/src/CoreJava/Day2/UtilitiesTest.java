package CoreJava.Day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
//import java.util.TreeSet;import javax.print.attribute.Size2DSyntax;
import java.util.TreeSet;

import CoreJava.Day1.Point;

public class UtilitiesTest { //Write method name with capital letter
	
	public static void testStack(Stack<Point> points) { //stack can have duplicate elements
		
		points.push(new Point(2,3)); //push to add element to stack
		points.push(new Point(2,4));
		points.push(new Point(2,3));
		points.push(new Point(2,5));
		System.out.println(points.size());
		System.out.println(points);
		System.out.println(points.peek()); //just displays top element in stack
		System.out.println(points.pop());  //removes stacks top element
	}
	
	public static void testMap(Map<String, Point> points) {
		points.put("2,3", new Point(2,3));
		points.put("2,3", new Point(2,3));
		points.put("2,4", new Point(3,2));
		points.put("3,2", new Point(2,4));
		System.out.println(points.size());
		System.out.println(points);
	}
	
	public static void testList(List<Point> points) {
	
		Point p = new Point(2,3);
		Point p1 = new Point(2,3);

		points.add(p);
		points.add(p1);
		points.add(p);
		points.add(new Point(3,2));
		points.add(new Point(4,5));
		System.out.println("Size = "+points.size()); //size() mean number of points 
		System.out.println(points);
		
	}

	public static void testSet(Set<Point> points) { //Write method name with small letter and significant name with capital letter
		
		Point p = new Point(2,3);
		Point p1 = new Point(2,3);
//		Set<Point> points = new HashSet<>();
		points.add(p);
		points.add(p1);
		points.add(p);
		points.add(new Point(3,2));
		points.add(new Point(4,5));
		System.out.println("Size = "+points.size()); //size() mean number of points 
		System.out.println(points);
	}
	
	

	
	public static void main(String[] args) {

//		testSet(new HashSet<Point>());
		testSet(new TreeSet<Point>());
//		testList(new ArrayList<Point>());
//		testList(new LinkedList<Point>());
//		testMap(new HashMap<>());
//		testMap(new TreeMap<>());
//		testStack(new Stack<Point>());
	}

}

//order doesn't matter for set, but it checks for duplicates
