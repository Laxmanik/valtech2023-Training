package CoreJava.Day2;

public class DivideByZeroException extends /*Exception(checked at compile time gives error)*/ RuntimeException /*Unchecked exception during compile time)*/
{
	
	public DivideByZeroException(String message) {
		super(message);
	}
	
}

