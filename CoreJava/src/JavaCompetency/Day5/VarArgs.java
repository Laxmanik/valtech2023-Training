package JavaCompetency.Day5;

public class VarArgs {

	public int add(int a , int ... b) {   //b is array here, atleast one argument need to be pressent
		int result = a;                   //vararg should be last argument, it should be only one
		for(int b1 : b) {
			result += b1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		VarArgs va = new VarArgs();
		
		System.out.println(va.add(2));   //a-> 2, b-> empty array
		System.out.println(va.add(2, 3));   //a-> 2, b-> array with single element = 3
		System.out.println(va.add(2, 3, 4));  //a-> 2, b-> array with 2 elements = 3, 4
		System.out.println(va.add(2, 3, 4, 5)); //a-> 2, b-> array with 3 elements = 3, 4, 5
	}
}
