package CoreJava.Day3;

import java.util.Random;
import java.util.random.RandomGenerator;


public class EmployeeGenerator {
	
	static int age;

	static int experience;

	static int level;

	static String name;
	
	static Random random= new Random();
	
	
	public  int generateRandomNumber(int min, int max) {
		return (int)(((Math.random()*(max-min))+min));
	}

 

	public static String generateRandomString() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        int length = (int) (Math.random() * (10 - 3 + 1)) + 3;   //(10 - 3 + 1)) + 3;
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString();
	}

 

	public static void generateEmployee(EmployeeGenerator e) {

		age = e.generateRandomNumber(20, 61);
		experience = e.generateRandomNumber(0, age);
		level = e.generateRandomNumber(0, experience);
		name = generateRandomString();
		

	}

 

	public static void main(String[] args) {
		EmployeeGenerator emp = new EmployeeGenerator();
		EmployeeGenerator e1 = new EmployeeGenerator();
		generateEmployee(emp);
		generateEmployee(e1);
		System.out.println("Employee details \n"+"Name: " + emp.name +" Age: "+ emp.age+" Experience: "+ emp.experience+" Level "+emp.level);

	}
}

