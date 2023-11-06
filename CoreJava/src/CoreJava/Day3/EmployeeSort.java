package CoreJava.Day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class EmployeeSort {

	String name;
	int age, experience, seniority;
	double salary;
	
	public EmployeeSort(String name, int age, double salary, int experience, int seniority) {
//		super();
		this.name = name;
		this.seniority = seniority;
		this.age = age;
		this.experience = experience;
		this.salary = salary;
	}
	
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	
	public int getExperience() {
		return experience;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSeniority() {
		return seniority;
	}
	
	public String toString() {
		return "\nName = "+name+" Age = "+age+" Salary = "+salary+" Experience = "+experience+" Seniority = "+seniority;
	}
	
	
	
	public static void main(String[] args) {
		ArrayList<EmployeeSort> e = new ArrayList<EmployeeSort>();
		e.add(new EmployeeSort("Harsha", 22, 30000, 2, 3));
		e.add(new EmployeeSort("Govind", 22, 150000, 5, 5));
		e.add(new EmployeeSort("Laxman", 22, 20000, 1, 2));
		
		System.out.println("Sort Employee list by Experience");
		Comparator<EmployeeSort> ex = Comparator.comparing(EmployeeSort::getExperience);
		Collections.sort(e,ex);
		for(EmployeeSort emp: e) {
			System.out.println(emp.experience+" "+emp.name+" "+emp.age+" "+emp.salary+" "+emp.seniority);
		}
		
		System.out.println("\nSort Employee list by Name");
		Comparator<EmployeeSort> n = Comparator.comparing(EmployeeSort :: getName);
		Collections.sort(e, n);
		for(EmployeeSort emp:e) {
			System.out.println(emp.name+" "+emp.experience+" "+emp.age+" "+emp.salary+" "+emp.seniority);
		}
		
		System.out.println("\nSort Employee list by Seniority");
		Comparator<EmployeeSort> s = Comparator.comparing(EmployeeSort :: getSeniority);
		for(EmployeeSort emp:e) {
			System.out.println(emp.seniority+" "+emp.name+" "+emp.age+" "+emp.salary+" "+emp.experience);
		}
	}
}




//
//package CoreJava.Day2;
//
//import java.util.TreeSet;
//
//public class Employee {
//	String name, seniority;
//	int age, experience;
//	double salary;
//	
//	public Employee(String name, int age, double salary, int experience, String seniority) {
////		super();
//		this.name = name;
//		this.seniority = seniority;
//		this.age = age;
//		this.experience = experience;
//		this.salary = salary;
//	}
//	
//	@Override
//	public String toString() {
//		return "\nName = "+name+" Age = "+age+" Salary = "+salary+" Experience = "+experience+" Seniority = "+seniority;
//	}
//	
//	public static void compare(TreeSet<Employee> e) {
//		Employee e1 = new Employee(	"Harsha", 22, 30000, 2, "Manager");
//		Employee e2 = new Employee("Govind", 22, 150000, 5, "CEO");
//		Employee e3 = new Employee("Laxman", 22, 20000, 1, "TL");
//		System.out.println(e1+" "+e2+ " "+e3);
//	}
//	
//	public String getName(TreeSet<Employee> e) {
//		return name;
//	}
//	
//	public void getSeniority(TreeSet<Employee> e) {
//		this.seniority = seniority;
//	}
//	
//	public void getExperience(TreeSet<Employee> e) {
//		this.experience = experience;
//	}
//	
//	public static void main(String[] args) {
////		Employee e1 = new Employee(	"Harsha", 22, 30000, 2, "Manager");
////		Employee e2 = new Employee("Govind", 22, 150000, 5, "CEO");
////		Employee e3 = new Employee("Laxman", 22, 20000, 1, "TL");
//		compare(new TreeSet<Employee>());
//	}
//
//}
