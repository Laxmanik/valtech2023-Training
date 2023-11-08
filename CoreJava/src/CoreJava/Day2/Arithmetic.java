package CoreJava.Day2;

public interface Arithmetic {
	
	int ZERO = 0;
	
	int add(int a, int b);
	
	int sub(int a, int b);
	
	int mul(int a, int b);
	
	int div(int a, int b) throws DivideByZeroException;
	
//	public static void main(String[] args) {
//		AirthmeticImpl a=new AirthmeticImpl();
//		System.out.println(a.add(2,3));
//	}
}
