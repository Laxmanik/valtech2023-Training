package CoreJava.Day2;

public class ArithmeticImpl implements Arithmetic {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		return a*b;
	}

	@Override
	public int div(int a, int b) throws DivideByZeroException {
		
		if(b==0) {
			throw new DivideByZeroException("Zero cannot be used as denominator");
		}
		
		return a/b;
	}

	public static void main(String[] args) /*throws DivideByZeroException*/ {
		Arithmetic a = new ArithmeticImpl();
		System.out.println(a.add(2, 3));
		System.out.println(a.mul(2, 3));
		System.out.println(a.sub(3, 2));
		try {
			System.out.println(a.div(2, 0));
		} catch (DivideByZeroException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println("Willl this be seen");
		}
		//If the exception is handled the code after catch block will execute
//		System.out.println(a.mul(2, 4)); //this is executed
		finally {
			System.out.println(a.mul(4, 4));
		}
	}
	
}
