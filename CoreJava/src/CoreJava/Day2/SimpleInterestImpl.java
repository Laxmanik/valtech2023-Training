package CoreJava.Day2;

public class SimpleInterestImpl implements SimpleInterest{
	
	private Arithmetic arithmetic;
	
	public SimpleInterestImpl(Arithmetic arithmetic) {
		this.arithmetic=arithmetic;
	}

	public void setAirthmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}

	@Override
	public double computeSimpleInterest(int principal, int roi, int duration) {
		int result=arithmetic.mul(principal, roi);
		result = arithmetic.mul(result, duration);
		return arithmetic.div(result, 100);
	}

	public static void main(String[] args) {
		Arithmetic arithmetic = new ArithmeticImpl();
		SimpleInterest si = new SimpleInterestImpl(arithmetic);
		System.out.println(si.computeSimpleInterest(200, 3, 4));
	}
	
}
